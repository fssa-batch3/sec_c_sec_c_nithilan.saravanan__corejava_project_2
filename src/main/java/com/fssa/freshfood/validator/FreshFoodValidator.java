package com.fssa.freshfood.validator;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.freshfood.errors.FreshFoodValidatorErrors;
import com.fssa.freshfood.model.FreshFood;
import com.mysql.cj.jdbc.result.UpdatableResultSet;

public class FreshFoodValidator {

	// Validation for Food Class
	public static boolean validate(FreshFood food) throws Exception {
		if (food == null) {
			throw new Exception(FreshFoodValidatorErrors.INVALID_NULL);
		}
		validateFoodName(food.getFoodName());
		validateFoodId(food.getFoodId());
		validateHotelName(food.getHotelName());
		validateAddress(food.getAddress());
		validatePrice(food.getPrice());
		validateRating(food.getRating());
		validateuploadedDate(food.getUploadedDate());
		validateFoodImageLink(food.getFoodImageLink());
		return true;
	}

	// Validation for Food Name
	public static boolean validateFoodName(String foodName) throws Exception {
		if (foodName == null || foodName.trim().equals("")) {
			throw new Exception(FreshFoodValidatorErrors.INVALID_FOODNAME);
		}

		String regex = "^[a-zA-Z]*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(foodName);
		boolean isMatch = matcher.matches();

		if (!isMatch) {
			throw new Exception(FreshFoodValidatorErrors.INVALID_PATTERN_FOODNAME);
		}

		return true;
	}

	// Validation for Food Id
	public static boolean validateFoodId(int id) throws Exception {
		if (id <= 0) {
			throw new Exception(FreshFoodValidatorErrors.INVALID_FOOD_ID);
		}
		return true;
	}

	// Validation for Hotel Name
	public static boolean validateHotelName(String hotelName) throws Exception {
		if (hotelName == null || hotelName.trim().equals("")) {
			throw new Exception(FreshFoodValidatorErrors.INVALID_HOTELNAME);
		}

		String regex = "^[a-zA-Z0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(hotelName);
		boolean isMatch = matcher.matches();

		if (!isMatch) {
			throw new Exception(FreshFoodValidatorErrors.INVALID_PATTERN_HOTELNAME);
		}

		return true;
	}

	// Validation for Address
	public static boolean validateAddress(String address) throws Exception {
		if (address == null || address.trim().equals("")) {
			throw new Exception(FreshFoodValidatorErrors.INVALID_ADDRESS);
		}
		return true;
	}

	// Validation for Price
	public static boolean validatePrice(Double price) throws Exception {
		if (price <= 0) {
			throw new Exception(FreshFoodValidatorErrors.INVALID_PRICE);
		}
		return true;
	}

	// Validation for Rating
	public static boolean validateRating(Double rating) throws Exception {
		if (rating < 0) {
			throw new Exception(FreshFoodValidatorErrors.INVALID_RATING);
		}
		return true;
	}

	// Validation for Uploaded Date
	public static boolean validateuploadedDate(LocalDate uploadedDate) throws Exception {
		LocalDate today = LocalDate.now();
		if (uploadedDate == null) {
			throw new Exception(FreshFoodValidatorErrors.INVALID_DATE_NULL);
		} else if (uploadedDate.isAfter(today)) {
			throw new Exception(FreshFoodValidatorErrors.INVALID_DATE_FORMAT);
		}
		return true;
	}

	// Validation for Food Image Link
	public static boolean validateFoodImageLink(String foodImageLink) throws Exception {
		if (foodImageLink == null) {
			throw new Exception(FreshFoodValidatorErrors.INVALID_LINK_NULL);
		}
		String urlRegex = "(?i)\\b((https?|ftp)://)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?\\.(jpg|jpeg|gif|png|bmp)\\b";
		Pattern pattern = Pattern.compile(urlRegex);
		Matcher matcher = pattern.matcher(foodImageLink);
		if (!matcher.matches()) {
			throw new Exception(FreshFoodValidatorErrors.INVALID_LINK);
		}

		return true;
	}
}
