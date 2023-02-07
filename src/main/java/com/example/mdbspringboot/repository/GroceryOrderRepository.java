package com.example.mdbspringboot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.mdbspringboot.model.GroceryOrder;

public interface GroceryOrderRepository extends MongoRepository<GroceryOrder, String> {
	
	@Query(value = "{ordernum:'?0'}", sort = "{_id: 1}")
	public GroceryOrder findGroceryOrderByOrdernum(String ordernum);

	@Query(value="{id:'?0'}")
	public GroceryOrder findFirstOrder(int id);
	
	@Query(value="{}", sort = "{_id: 1}" )
	public List<GroceryOrder> findAll();

	//public void save();
	
	public long count();

}
