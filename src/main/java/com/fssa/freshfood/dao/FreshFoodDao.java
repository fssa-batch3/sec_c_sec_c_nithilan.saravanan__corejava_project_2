package com.fssa.freshfood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fssa.freshfood.model.FreshFood;
import com.fssa.freshfood.util.ConnectionUtil;

public class FreshFoodDao {

	// Method to create a new food item in the database
	public static boolean createFood(FreshFood food) throws SQLException {
		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "insert into food(foodname, hotelname, address, foodimagelink, price, uploadeddate, rating) values (?,?,?,?,?,?,?)";
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setString(1, food.getFoodName());
				pst.setString(2, food.getHotelName());
				pst.setString(3, food.getAddress());
				pst.setString(4, food.getFoodImageLink());
				pst.setDouble(5, food.getPrice());
				pst.setDate(6, java.sql.Date.valueOf(food.getUploadedDate()));
				pst.setDouble(7, food.getRating());
				int rows = pst.executeUpdate();
				// TODO use logger
				System.out.println(rows);
				return (rows > 0) ? true : false; // if no row is affected it will return true else it will return false and the function will fail
//				
			}
		}
	}

	// Method to find a food item by its name in the database
	public static FreshFood findfoodByName(String name) throws SQLException {
		FreshFood fresh = null;
		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM food WHERE foodname = ?";
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setString(1, name);
				try (ResultSet resultSet = pst.executeQuery()) {
					if (resultSet.next()) {
						fresh = new FreshFood();
						fresh.setFoodId(resultSet.getInt("id"));
						fresh.setFoodName(resultSet.getString("foodname"));
						fresh.setHotelName(resultSet.getString("hotelname"));
						fresh.setAddress(resultSet.getString("address"));
						fresh.setPrice(resultSet.getDouble("price"));
						fresh.setUploadedDate(resultSet.getDate("uploadeddate").toLocalDate());
						fresh.setFoodImageLink(resultSet.getString("foodimagelink"));
						fresh.setRating(resultSet.getDouble("rating"));

					}
				}
			}
		}
		return fresh;
	}

	// Method to delete a food item from the database by its name
	public static boolean delete(String name) throws Exception {
		String query = "DELETE FROM food WHERE foodname = ?";
		int rows;
		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setString(1, name);
				rows = pst.executeUpdate();
				if (rows == 0) {
					throw new Exception("Deletion completed");
				}
			}
		}
		return (rows > 0) ? true : false;
	}

	// Method to update a food item's hotel name and price in the database by its
	// name
	public static boolean update(String foodname, String foodimagelink, double price) throws Exception {
		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "UPDATE food SET  foodimagelink = ?, price = ? WHERE foodname = ?";
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setString(1, foodimagelink);
				pst.setDouble(2, price);
				pst.setString(3, foodname);
				System.out.println(pst);
				int rows = pst.executeUpdate();
				
				System.out.println("Number of affected rows: " + rows);
				return (rows > 0) ? true : false;
			}
		}
	}

	public static List<FreshFood> getAllFoods() throws SQLException {
		List<FreshFood> freshFoodList = new ArrayList<FreshFood>();

		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM food ";
			try (PreparedStatement pst = con.prepareStatement(query)) {
				try (ResultSet resultSet = pst.executeQuery()) {
					while (resultSet.next()) {
						FreshFood fresh = new FreshFood();
						fresh.setFoodId(resultSet.getInt("id"));
						fresh.setFoodName(resultSet.getString("foodname"));
						fresh.setHotelName(resultSet.getString("hotelname"));
						fresh.setAddress(resultSet.getString("address"));
						fresh.setPrice(resultSet.getDouble("price"));
						fresh.setUploadedDate(resultSet.getDate("uploadeddate").toLocalDate());
						fresh.setFoodImageLink(resultSet.getString("foodimagelink"));
						fresh.setRating(resultSet.getDouble("rating"));
						freshFoodList.add(fresh);
					}
				}
			}
		}
		return freshFoodList;
	}

	public static void main(String[] args) throws Exception {
		FreshFood food = new FreshFood("Biryani", 3, "A2B", "madurai",
				"https://norecipes.com/wp-content/uploads/2017/05/chicken-biryani-006.jpg", 200.0,
				LocalDate.of(2023, 07, 31), 4.4);

		// createFood(food);
		// update("Dosa", "ABC", 100,"madurai");
		// delete("Biryani");
		findfoodByName("Biryani");
	}
}
