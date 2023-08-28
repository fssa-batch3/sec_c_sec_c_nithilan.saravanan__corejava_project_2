package com.fssa.freshfood.dao;

import java.time.LocalDate;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.freshfood.model.FreshFood;

public class TestFreshFoodDAO {
	
	FreshFoodDao ff=new FreshFoodDao();
	FreshFood food = new FreshFood("briyani", 3, "A2B", "Chennai",
			"https://norecipes.com/wp-content/uploads/2017/05/chicken-biryani-006.jpg", 200.0,
			LocalDate.of(2005, 11, 11), 4.4);

	@Test
	public void testValidfood() throws Exception {
		Assertions.assertTrue(ff.createFood(food));
		
	}
	
	@Test
	public void testValidUpdatefood() throws Exception {
		Assertions.assertTrue(ff.update(food.getFoodName(), food.getHotelName(), food.getPrice()));
		
	}
	
	@Order(3)
	@Test
	public void testValidDeletefood() throws Exception {
		Assertions.assertTrue(ff.delete(food.getFoodName()));
		
	}
	
}