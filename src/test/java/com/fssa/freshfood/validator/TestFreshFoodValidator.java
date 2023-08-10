package com.fssa.freshfood.validator;


import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.freshfood.errors.FreshFoodValidatorErrors;
import com.fssa.freshfood.model.FreshFood;



public class TestFreshFoodValidator {

	// Sample valid and invalid FreshFood instances for testing
	FreshFood food = new FreshFood("vriyani", 3, "A2B", "Chennai",
			"https://norecipes.com/wp-content/uploads/2017/05/chicken-biryani-006.jpg", 200.0,
			LocalDate.of(2005, 11, 11), 4.4);
	
	FreshFood invalidFood = new FreshFood(null, -3, null, null, null, 0, null, -3);

	// Test case for validate(FreshFood food)
	@Test
	public void TestValidate() throws Exception {
		Assertions.assertTrue(FreshFoodValidator.validate(food));
	}

	@Test
	public void TestInValidate() {
		try {
			FreshFoodValidator.validate(null);
		} catch (Exception e) {
			Assertions.assertEquals(FreshFoodValidatorErrors.INVALID_NULL, e.getMessage());
		}
	}

	// Test case for validateFoodName(String foodName)
	@Test
	public void TestValidateFoodName() throws Exception {
		Assertions.assertTrue(FreshFoodValidator.validateFoodName(food.getFoodName()));
	}

	@Test
	public void TestNullFoodName() {
		try {
			FreshFoodValidator.validateFoodName(invalidFood.getFoodName());
		} catch (Exception e) {
			Assertions.assertEquals(FreshFoodValidatorErrors.INVALID_FOODNAME, e.getMessage());
		}
	}

	@Test
	public void TestInValidFoodName() {
		try {
			FreshFoodValidator.validateFoodName("hu6778*");
		} catch (Exception e) {
			Assertions.assertEquals(FreshFoodValidatorErrors.INVALID_PATTERN_FOODNAME, e.getMessage());
		}
	}

	// Test case for validateHotelName(String hotelName)
	@Test
	public void TestValidateHotelname() throws Exception {
		Assertions.assertTrue(FreshFoodValidator.validateHotelName(food.getHotelName()));
	}

	@Test
	public void TestNullHotelName() {
		try {
			FreshFoodValidator.validateHotelName(invalidFood.getHotelName());
		} catch (Exception e) {
			Assertions.assertEquals(FreshFoodValidatorErrors.INVALID_HOTELNAME, e.getMessage());
		}
	}

	@Test
	public void TestInValidHotelName() {
		try {
			FreshFoodValidator.validateHotelName("hu6@$%^&778*");
		} catch (Exception e) {
			Assertions.assertEquals(FreshFoodValidatorErrors.INVALID_PATTERN_HOTELNAME, e.getMessage());
		}
	}

	// Test case for validateAddress(String address)
	@Test
	public void TestValidateaddress() throws Exception {
		Assertions.assertTrue(FreshFoodValidator.validateAddress(food.getAddress()));
	}

	@Test
	public void TestInValidateaddress() {
		try {
			FreshFoodValidator.validateAddress(invalidFood.getAddress());
		} catch (Exception e) {
			Assertions.assertEquals(FreshFoodValidatorErrors.INVALID_ADDRESS, e.getMessage());
		}
	}

	// Test case for validatePrice(Double price)
	@Test
	public void testValidatePrice() throws Exception {
		Assertions.assertTrue(FreshFoodValidator.validatePrice(food.getPrice()));
	}

	@Test
	public void testInvalidPrice() {
		try {
			FreshFoodValidator.validatePrice(invalidFood.getPrice());
		} catch (Exception e) {
			Assertions.assertEquals(FreshFoodValidatorErrors.INVALID_PRICE, e.getMessage());
		}
	}

	// Test case for validateRating(Double rating)
	@Test
	public void testValidateRating() throws Exception {
		Assertions.assertTrue(FreshFoodValidator.validateRating(food.getRating()));
	}

	@Test
	public void testInvalidRating() {
		try {
			FreshFoodValidator.validateRating(invalidFood.getRating());
		} catch (Exception e) {
			Assertions.assertEquals(FreshFoodValidatorErrors.INVALID_RATING, e.getMessage());
		}
	}

	// Test case for validateUploadedDate(LocalDate uploadedDate)
	@Test
	public void testValidateUploadedDate() throws Exception {
		Assertions.assertTrue(FreshFoodValidator.validateuploadedDate(food.getUploadedDate()));
	}

	@Test
	public void testInValidateDateNull() {
		try {
			FreshFoodValidator.validateuploadedDate(invalidFood.getUploadedDate());
		} catch (Exception e) {
			Assertions.assertEquals(FreshFoodValidatorErrors.INVALID_DATE_NULL, e.getMessage());
		}
	}

	@Test
	public void testInValidateDateFormat() {
		try {
			FreshFoodValidator.validateuploadedDate(LocalDate.of(2035, 11, 11));
		} catch (Exception e) {
			Assertions.assertEquals(FreshFoodValidatorErrors.INVALID_DATE_FORMAT, e.getMessage());
		}
	}

	// Test case for validateFoodId(int id)
	@Test
	public void testValidateId() throws Exception {
		Assertions.assertTrue(FreshFoodValidator.validateFoodId(food.getFoodId()));
	}

	@Test
	public void testInvalidId() {
		try {
			FreshFoodValidator.validateFoodId(invalidFood.getFoodId());
		} catch (Exception e) {
			Assertions.assertEquals(FreshFoodValidatorErrors.INVALID_FOOD_ID, e.getMessage());
		}
	}

	// Test case for validateFoodImageLink(String foodImageLink)
	@Test
	public void testValidFoodImageLink() throws Exception {
		Assertions.assertTrue(FreshFoodValidator.validateFoodImageLink(food.getFoodImageLink()));
	}
	
	@Test
	public void testInValidFoodImageLinkNull() {
		try {
			FreshFoodValidator.validateFoodImageLink(invalidFood.getFoodImageLink());
		} catch (Exception e ) {
			Assertions.assertEquals(FreshFoodValidatorErrors.INVALID_LINK_NULL, e.getMessage());
		}
	}

	@Test
	public void testInValidFoodImageLinkPattern() {
		try {
			FreshFoodValidator.validateFoodImageLink("url");
		} catch (Exception e ) {
			Assertions.assertEquals(FreshFoodValidatorErrors.INVALID_LINK, e.getMessage());
		}
	}

}
