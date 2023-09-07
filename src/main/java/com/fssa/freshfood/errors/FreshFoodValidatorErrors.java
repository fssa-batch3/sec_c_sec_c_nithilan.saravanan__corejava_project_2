package com.fssa.freshfood.errors;

public interface FreshFoodValidatorErrors {

	public static final String INVALID_NULL = "Object can't be null";
	
	
	//Food name
	
	public static final String INVALID_FOODNAME = "Food Name can't be null";
	
	public static final String INVALID_PATTERN_FOODNAME = "Food Name must contain alphabets only";
//hotel name
	public static final String INVALID_HOTELNAME = "Hotel Name can't be null";

	public static final String INVALID_PATTERN_HOTELNAME = "Hotel Name must contain alphabets and number only";

	//Address
	public static final String INVALID_ADDRESS = "Address can't be null";
	
	//
	public static final String INVALID_PRICE= "Price can't be less than or equal to zero";

	public static final String INVALID_FOOD_ID= "ID can't be less than zero";
	
	public static final String INVALID_RATING= "Rating can't be less than zero";

	
	public static final String INVALID_DATE_NULL = "Date can't be null";
	
	public static final String INVALID_DATE_FORMAT = "Uploaded Date can't be In Future";
	
	public static final String INVALID_LINK_NULL = "Image URL can't be null";
	
	
	public static final String INVALID_LINK = "Link is invalid";
}
