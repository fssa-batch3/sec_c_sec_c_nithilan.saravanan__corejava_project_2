package com.fssa.freshfood.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.freshfood.dao.FreshFoodDao;
import com.fssa.freshfood.model.FreshFood;
import com.fssa.freshfood.validator.FreshFoodValidator;

public class FreshfoodService {
	
	
	public FreshfoodService(){
		
	}

	static FreshFoodValidator ffvalidate=new FreshFoodValidator();
	static FreshFoodDao ffDao=new FreshFoodDao();
	
	
	
	public boolean addNewFoodService(FreshFood ff) throws Exception {
		if (ffvalidate.validate(ff)) {// validate the give object food 
			ffDao.createFood(ff); // if valid the service layer create food method will be called 
		}
		return true;

	}
	
	public static boolean updateFoodService(String foodname, String hotelname, double price) throws Exception {
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
	
	public static  FreshFood getFoodDetailsService(String foodname) throws SQLException{
			
			return ffDao.findfoodByName(foodname);

	}

	public static List<FreshFood> getAllFoods() throws SQLException{
		return ffDao.getAllFoods();
	}



}
