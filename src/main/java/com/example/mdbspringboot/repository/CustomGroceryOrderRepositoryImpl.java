package com.example.mdbspringboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.example.mdbspringboot.model.GroceryOrder;

import com.example.mdbspringboot.util.constants;

@Component
public class CustomGroceryOrderRepositoryImpl implements CustomGroceryOrderRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	// Will find the oldest order with status = 'open' and attempt to process it
	// with the success/error results of operation logged
	public GroceryOrder updateGroceryOrderStatus(String status) {
		Query query = new Query(Criteria.where("status").is(constants.STATUS_OPEN))
			.with(Sort.by(Sort.Direction.ASC,"_id"));
		Update update = new Update();
		update.set("status", status);

		return mongoTemplate.findAndModify(query, update, GroceryOrder.class);
	}
}
