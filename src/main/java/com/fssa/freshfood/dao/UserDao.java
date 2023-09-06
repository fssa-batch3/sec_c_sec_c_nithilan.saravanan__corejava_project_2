package com.fssa.freshfood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.freshfood.model.User;
import com.fssa.freshfood.util.ConnectionUtil;
import com.fssa.freshfood.exceptions.*;

public class UserDao {
    // Insert a new user into the database
    public boolean insertUser(User user) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionUtil.getConnection();
            String sql = "INSERT INTO users (first_name, last_name, district, email, phone_number, pincode, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getDistrict());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPhoneNumber());
            statement.setString(6, user.getPincode());
            statement.setString(7, user.getPassword());

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace(); 
            throw new DAOException( e.getMessage());
        } finally {
            ConnectionUtil.close(null, statement, connection);
        }
    }

    // Retrieve a user by their email address
    public User getUserByEmail(String email) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            connection = ConnectionUtil.getConnection();
            String sql = "SELECT * FROM users WHERE email = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            result = statement.executeQuery();

            User user = null;
            if (result.next()) {
                int id = result.getInt("id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String district = result.getString("district");
                String phoneNumber = result.getString("phone_number");
                String pincode = result.getString("pincode");
                String password = result.getString("password");

                user = new User(id, firstName, lastName, district, email, phoneNumber, pincode, password);
            }

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException( e.getMessage());
        } finally {
            ConnectionUtil.close(result, statement, connection);
        }
    }

    // Update user data
    public boolean updateUser(User user) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionUtil.getConnection();
            String sql = "UPDATE users SET first_name=?, last_name=?, district=?, phone_number=?, pincode=?, password=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getDistrict());
            statement.setString(4, user.getPhoneNumber());
            statement.setString(5, user.getPincode());
            statement.setString(6, user.getPassword());
            statement.setInt(7, user.getId());

            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(e.getMessage());
        } finally {
            ConnectionUtil.close(null, statement, connection);
        }
    }

    // Delete user by ID
    public boolean deleteUser(int userId) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionUtil.getConnection();
            String sql = "DELETE FROM users WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);

            int rowsDeleted = statement.executeUpdate();

            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException( e.getMessage());
        } finally {
            ConnectionUtil.close(null, statement, connection);
        }
    }

    // ...

    // Retrieve all users from the database
    public List<User> getAllUsers() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        List<User> userList = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            String sql = "SELECT * FROM users";
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String district = result.getString("district");
                String email = result.getString("email");
                String phoneNumber = result.getString("phone_number");
                String pincode = result.getString("pincode");
                String password = result.getString("password");

                User user = new User(id, firstName, lastName, district, email, phoneNumber, pincode, password);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException( e.getMessage());
        } finally {
            ConnectionUtil.close(result, statement, connection);
        }

        return userList;
    }
}
