package com.fssa.freshfood.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.freshfood.model.FreshFood;

public class TestFreshFoodService {
	
	FreshfoodService service = new FreshfoodService();

	@Test
	public void addNewFood() throws Exception {
		
		FreshFood food = new FreshFood("briyani", 3, "A2B", "Chennai",
				"https://norecipes.com/wp-content/uploads/2017/05/chicken-biryani-006.jpg", 200.0,
				LocalDate.of(2005, 11, 11), 4.4);
		
		Assertions.assertTrue(service.addNewFoodService(food));
		
	} 
	
	@Test
	public void updateFood() throws Exception {
		
		String foodName = "briyani";
		String hotelName = "vss";
		double price = 300.0;
		
		Assertions.assertTrue(service.updateFoodService(foodName,hotelName,price));
		
	}  
	
	@Test
	public void deleteFood() throws Exception {
		
		String foodName = "briyani";
		
		Assertions.assertTrue(service.deleteFoodService(foodName));
		
	} 
	
	@Test
	public void getFoodDetails() throws Exception {
		
		String foodName = "briyani";
		
		Assertions.assertTrue(service.getFoodDetailsService(foodName));
		
	} 

}
