package com.fssa.freshfood.model;

import java.time.LocalDate;

public class FreshFood {

	// Attributes representing properties of the food item
	private String foodName;           // Name of the food item
	private int foodId;                // Unique identifier for the food item
	private String hotelName;          // Name of the hotel/restaurant offering the food item
	private String address;            // Address of the hotel/restaurant
	private String foodImageLink;      // URL link to the image of the food item
	private double price;              // Price of the food item
	private LocalDate uploadedDate;    // Date when the food item was uploaded/added to the system
	private double rating;             // Rating of the food item

	// Constructor to initialize the food item with provided values
	public FreshFood(String foodName, int foodId, String hotelName, String address, String foodImageLink, double price,
			LocalDate uploadedDate, double rating) {
		this.foodName = foodName;
		this.foodId = foodId;
		this.hotelName = hotelName; 
		this.address = address;
		this.foodImageLink = foodImageLink;
		this.price = price;
		this.uploadedDate = uploadedDate; 
		this.rating = rating;
	}

	// Default constructor (no arguments)
	public FreshFood() {
		// Default Constructor
	}

	// Getter and Setter methods for each attribute

	public String getFoodName() {
		return foodName;
	}
 
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFoodImageLink() {
		return foodImageLink;
	}

	public void setFoodImageLink(String foodImageLink) {
		this.foodImageLink = foodImageLink;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(LocalDate uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "FreshFood [foodName=" + foodName + ", foodId=" + foodId + ", hotelName=" + hotelName + ", address="
				+ address + ", foodImageLink=" + foodImageLink + ", price=" + price + ", uploadedDate=" + uploadedDate
				+ ", rating=" + rating + "]";
	}
	
	
	

//	private long phoneNumber;

}
