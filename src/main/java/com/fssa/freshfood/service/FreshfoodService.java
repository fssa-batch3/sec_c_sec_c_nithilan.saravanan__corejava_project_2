package com.fssa.freshfood.service;

import java.sql.SQLException;

import com.fssa.freshfood.dao.FreshFoodDao;
import com.fssa.freshfood.model.FreshFood;
import com.fssa.freshfood.validator.FreshFoodValidator;

public class FreshfoodService {
	
	
	public FreshfoodService(){
		
	}

	FreshFoodValidator ffvalidate=new FreshFoodValidator();
	FreshFoodDao ffDao=new FreshFoodDao();
	
	
	public boolean addNewFoodService(FreshFood ff) throws Exception {
		if (ffvalidate.validate(ff)) {
			ffDao.createFood(ff);
		}
		return true;

	}
	
	public  boolean updateFoodService(String foodname, String hotelname, double price) throws Exception {
		if (ffvalidate.validateFoodName(foodname)&& ffvalidate.validateHotelName(hotelname) && ffvalidate.validatePrice(price)) {
			ffDao.update(foodname,hotelname,price);
		}
		return true;

	}
	
	public boolean deleteFoodService(String foodname) throws Exception {
		if(ffvalidate.validateFoodName(foodname)) {
			ffDao.delete(foodname);
		}
		return true;
		 
	}
	
	public  boolean getFoodDetailsService(String foodname) throws SQLException{

		ffDao.findfoodByName(foodname);
		return true;

	}

}
