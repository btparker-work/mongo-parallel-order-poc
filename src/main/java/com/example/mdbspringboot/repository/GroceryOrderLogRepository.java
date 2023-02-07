package com.example.mdbspringboot.repository;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.mdbspringboot.model.GroceryOrderLog;

public interface GroceryOrderLogRepository extends MongoRepository<GroceryOrderLog, String> {
	
	@Query(value = "{ordernum:'?0'}", sort = "{_id: 1}")
	GroceryOrderLog findGroceryOrderByOrdernum(String ordernum);
	
	@Query(value="{}", sort = "{_id: 1}" )
	List<GroceryOrderLog> findAll();
	
	public long count();

}
