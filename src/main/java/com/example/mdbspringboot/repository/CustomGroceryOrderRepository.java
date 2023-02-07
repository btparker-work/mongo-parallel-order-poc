package com.example.mdbspringboot.repository;

import com.example.mdbspringboot.model.GroceryOrder;

public interface CustomGroceryOrderRepository {
	
	public GroceryOrder updateGroceryOrderStatus(String status);

}
