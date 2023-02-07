package com.example.mdbspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.mdbspringboot.model.GroceryOrder;
import com.example.mdbspringboot.model.GroceryOrderLog;
import com.example.mdbspringboot.repository.CustomGroceryOrderRepository;
import com.example.mdbspringboot.repository.GroceryOrderRepository;
import com.example.mdbspringboot.repository.GroceryOrderLogRepository;
import com.mongodb.client.ChangeStreamIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.changestream.FullDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.example.mdbspringboot.util.constants;

@SpringBootApplication
@EnableMongoRepositories
public class MdbSpringBootApplication implements CommandLineRunner {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	GroceryOrderRepository groceryOrderRepo;

	@Autowired
	CustomGroceryOrderRepository customGroceryOrderRepo;

	@Autowired
	GroceryOrderLogRepository groceryOrderLogRepo;

	@Value("${instance.name}")
	private String instance;

	public static void main(String[] args) {
		SpringApplication.run(MdbSpringBootApplication.class, args);
	}

	public void run(String... args) {

		// First scan GroceryOrders collection for any newly added/updated orders added since last service start
		GroceryOrder order = null;
		do {
			order = findGroceryOrderToProcess();
		} while(order!=null);

		// Now register for ChangeStream events on ChangeOrder udpates/inserts to process orders changed after service startup
		MongoCollection<Document> collection = mongoTemplate.getCollection("GroceryOrder");

		List<Bson> pipeline = Arrays.asList(Aggregates.match(Filters.in("operationType", Arrays.asList("insert","update"))));

		ChangeStreamIterable<Document> changeStream = collection.watch(pipeline)
			.fullDocument(FullDocument.UPDATE_LOOKUP);

		Runnable task = () -> changeStream.forEach(event -> findGroceryOrderToProcess());
		task.run();		
	}

	private GroceryOrder findGroceryOrderToProcess() {
		  GroceryOrder order = null; 	
		  try {
			order = customGroceryOrderRepo.updateGroceryOrderStatus(constants.STATUS_WIP);
			if(order != null) {
			  //call the ThirdPartyShoppingSerivceWrapper here to do work
			  //remember only one of this service can process any one order
			  GroceryOrderLog log = new GroceryOrderLog(order.getOrdernum(),constants.STATUS_WIP,"Processed order SUCCESSFUL",instance);
			  groceryOrderLogRepo.save(log);
		    } else {
			  throw new Exception();
			}
		  } catch(Exception e) {
			GroceryOrderLog log = new GroceryOrderLog("N/A",constants.STATUS_ERROR,"Order already processed by other instance",instance);
			System.out.println(log.toString());
			//groceryOrderLogRepo.save(log);
		  }
		  return order;
	}

}