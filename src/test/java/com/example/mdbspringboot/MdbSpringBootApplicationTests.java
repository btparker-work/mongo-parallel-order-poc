package com.example.mdbspringboot;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import com.example.mdbspringboot.model.GroceryOrder;

import com.example.mdbspringboot.repository.GroceryOrderLogRepository;
import com.example.mdbspringboot.repository.GroceryOrderRepository;

@DataMongoTest
class MdbSpringBootApplicationTests {
/*
	@Autowired
	private GroceryOrderRepository groceryOrderRepo;

	@Autowired
	private GroceryOrderLogRepository groceryOrderLogRepo;
	
	@Test
	void truncOrders() {
		groceryOrderRepo.deleteAll();
		groceryOrderLogRepo.deleteAll();
		long count = groceryOrderRepo.count();
		assertThat(count==0);
	}

	@Test
	void addTenMoreOrders() {
		groceryOrderRepo.save(new GroceryOrder());
		groceryOrderRepo.save(new GroceryOrder());
		groceryOrderRepo.save(new GroceryOrder());
		groceryOrderRepo.save(new GroceryOrder());
		groceryOrderRepo.save(new GroceryOrder());
		groceryOrderRepo.save(new GroceryOrder());
		groceryOrderRepo.save(new GroceryOrder());
		groceryOrderRepo.save(new GroceryOrder());
		groceryOrderRepo.save(new GroceryOrder());
		long count = groceryOrderRepo.count();
		assertThat(count>0);
	}
*/
	/* @Test
	public void findsByItem() {

		List<Customer> result = repository.findByLastName("Beauford");

		assertThat(result).hasSize(1).extracting("firstName").contains("Carter");
	}

	@Test
	public void findsByCategory() {

		Customer probe = new Customer(null, "Matthews");

		List<Customer> result = repository.findAll(Example.of(probe));

		assertThat(result).hasSize(2).extracting("firstName").contains("Dave", "Oliver August");
	} 
	
	// CRUD operations

	//CREATE
	void createGroceryItems() {
		System.out.println("Data creation started...");

		groceryOrderRepo.save(new GroceryOrder("Whole Wheat Biscuit", 5, "snacks"));
		groceryOrderRepo.save(new GroceryOrder("XYZ Kodo Millet healthy", 2, "millets"));
		groceryOrderRepo.save(new GroceryOrder("Dried Whole Red Chilli", 2, "spices"));
		groceryOrderRepo.save(new GroceryOrder("Healthy Pearl Millet", 1, "millets"));
		groceryOrderRepo.save(new GroceryOrder("Bonny Cheese Crackers Plain", 6, "snacks"));
		
		System.out.println("Data creation complete...");
	}
	
	// READ
	// 1. Show all the data
	 public void showAllGroceryItems() {
		 
		 itemList = groceryOrderRepo.findAll();
		 
		 itemList.forEach(item -> System.out.println(getItemDetails(item)));
	 }
	 
	 // 2. Get item by name
	 public void getGroceryItemByName(String name) {
		 System.out.println("Getting item by name: " + name);
		 GroceryOrder item = groceryOrderRepo.findItemByName(name);
		 System.out.println(getItemDetails(item));
	 }
	 
	 // 3. Get name and items of a all items of a particular category
	 public void getItemsByCategory(String category) {
		 System.out.println("Getting items for the category " + category);
		 List<GroceryOrder> list = groceryOrderRepo.findAll(category);
		 
		 list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getItemQuantity()));
	 }
	 
	 // 4. Get count of documents in the collection
	 public void findCountOfGroceryItems() {
		 long count = groceryOrderRepo.count();
		 System.out.println("Number of documents in the collection = " + count);
	 }
	 
	 // UPDATE APPROACH 1: Using MongoRepository
	 public void updateCategoryName(String category) {
		 
		 // Change to this new value
		 String newCategory = "munchies";
		 
		 // Find all the items with the category 
		 List<GroceryOrder> list = groceryOrderRepo.findAll(category);
		 
		 list.forEach(item -> {
			 // Update the category in each document
			 item.setCategory(newCategory);
		 });
		 
		 // Save all the items in database
		 List<GroceryOrder> itemsUpdated = groceryOrderRepo.saveAll(list);
		 
		 if(itemsUpdated != null)
			 System.out.println("Successfully updated " + itemsUpdated.size() + " items.");		 
	 }
	 
	 
	 // UPDATE APPROACH 2: Using MongoTemplate
	 public void updateItemQuantity(String name, float newQuantity) {
		 System.out.println("Updating quantity for " + name);
		 customRepo.updateItemQuantity(name, newQuantity);
	 }
	 
	 // DELETE
	 public void deleteGroceryItem(String id) {
		 groceryOrderRepo.deleteById(id);
		 System.out.println("Item with id " + id + " deleted...");
	 }
	 // Print details in readable form
	 
	 public String getItemDetails(GroceryOrder item) {

		 System.out.println(
		 "Item Name: " + item.getName() + 
		 ", \nItem Quantity: " + item.getItemQuantity() + 
		 ", \nItem Category: " + item.getCategory()
		 );
		 
		 return "";
	 }
	*/
}
