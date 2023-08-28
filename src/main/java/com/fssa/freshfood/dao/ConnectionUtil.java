package com.fssa.freshfood.dao;

import java.sql.Connection;

import java.sql.DriverManager;

public class ConnectionUtil {

	public static Connection getConnection() {
		Connection con = null;

		String url, userName, passWord;

		url = System.getenv("DATABASE_HOST");
		userName = System.getenv("DATABASE_USERNAME");
		passWord = System.getenv("DATABASE_PASSWORD");

		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, passWord);
			System.out.println(con);
			System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect to the database");
		}
		return con;
	}

//	public static void main(String[] args) {
//		getConnection();
//	}
//	

}
