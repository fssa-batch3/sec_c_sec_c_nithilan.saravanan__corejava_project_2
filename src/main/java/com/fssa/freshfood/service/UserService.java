package com.fssa.freshfood.service;

import java.util.List;

import com.fssa.freshfood.dao.UserDao;
import com.fssa.freshfood.exceptions.DAOException;
import com.fssa.freshfood.exceptions.InvalidUserException;
import com.fssa.freshfood.exceptions.UserServiceException;
import com.fssa.freshfood.model.User;
import com.fssa.freshfood.validator.UserValidator;

public class UserService {
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao(); 
    }

    // Create a new user
    public boolean createUser(User user) throws UserServiceException, InvalidUserException {
        try {
            // Validate user data using the UserValidator
            if (UserValidator.isValid(user)) {
                // Insert the user into the database
                return userDao.insertUser(user);
            } else {
                throw new InvalidUserException("Invalid user data");
            }
        } catch (  DAOException e) {
            // Wrap and rethrow the exception as a UserServiceException
            throw new UserServiceException( e.getMessage());
        }
    }

    // Retrieve a user by email
    public User getUserByEmail(String email) throws InvalidUserException {
        try {
        	User user = userDao.getUserByEmail(email);
        	if(user == null)
        		 throw new InvalidUserException("invalid email");
        	else {
        	return user;
        	}
		} catch (DAOException e) {
			 throw new InvalidUserException(e.getMessage());
			
		}
    }

    // Update user data
    public boolean updateUser(User user) throws InvalidUserException {
        // You can add validation logic here if needed.
        try {
			return userDao.updateUser(user);
		} catch (DAOException e) {
			 throw new InvalidUserException(e.getMessage());
		}
    }

    // Delete user by ID
    public boolean deleteUser(int userId) throws InvalidUserException {
        try {
			return userDao.deleteUser(userId);
		} catch (DAOException e) {
			 throw new InvalidUserException(e.getMessage());
		}
    }

    // Retrieve all users
    public List<User> getAllUsers() throws InvalidUserException  {
        try {
			return userDao.getAllUsers();
		} catch (DAOException e) {
			 throw new InvalidUserException(e.getMessage());
		}
    }

    // Additional Methods (Optional)
    
    // Add any additional methods or business logic as needed for your application.
    // For example, you can implement methods to validate user data, authenticate users, or perform other operations.
}
