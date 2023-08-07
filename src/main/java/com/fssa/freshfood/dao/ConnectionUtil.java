package com.fssa.freshfood.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {

	// Method to establish a database connection
	public static Connection getConnection() {

		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/freshfood"; // Database URL
		String userName = "root"; // Database username
		String passWord = "123456"; // Database password

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver class
			con = DriverManager.getConnection(url, userName, passWord); // Establish a connection to the database
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect to the database"); // Throw a runtime exception if connection
																				// fails
		}

		return con;
	}

	// Method to close the database connection, statement, and result set
	public static void close(Connection conn, Statement stmt, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close(); // Close the result set if not null
			}
			if (stmt != null) {
				stmt.close(); // Close the statement if not null
			}
			if (conn != null) {
				conn.close(); // Close the connection if not null
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// No need to rethrow the exception since it's just closing the resources.
		}
	}
}
