package com.fssa.freshfood.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.freshfood.model.FreshFood;
import com.fssa.freshfood.util.*;



public class TestFreshFoodService {

	FreshfoodService service = new FreshfoodService();

	@Test
	void addNewFood() throws Exception {

		// create a object
		FreshFood food = new FreshFood("Dosa", 3, "Saravan Bhavan", "Chennai",
				"https://norecipes.com/wp-content/uploads/2017/05/chicken-biryani-006.jpg", 200.0,
				LocalDate.of(2023, 8, 11), 4.4);

		// add the object using service layer
		Assertions.assertTrue(service.addNewFoodService(food));

	}

	@Test
	public void updateFood() throws Exception {

		String foodName = "Chicken Chukka";
		String hotelName = "Thalapakatti";
		double price = 300.0;

		Assertions.assertTrue(service.updateFoodService(foodName, hotelName, price));

	}

	@Test
	public void deleteFood() throws Exception {

		String foodName = "Chicken Chukka";

		Assertions.assertTrue(service.deleteFoodService(foodName));

	}

	@Test
	public void getFoodByNameDetails() throws Exception {

		String foodName = "briyani";
		FreshFood fresh = service.getFoodDetailsService(foodName);
		Logger.info(fresh);

	}

	@Test
	public void getAllFoodDetails() throws SQLException {
		List<FreshFood> freshFoodList = service.getAllFoods();
		for (FreshFood ele : freshFoodList) {
			Logger.info(ele);
		}
	}

}
