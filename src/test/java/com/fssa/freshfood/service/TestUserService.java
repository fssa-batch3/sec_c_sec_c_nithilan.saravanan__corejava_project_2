package com.fssa.freshfood.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import com.fssa.freshfood.dao.UserDao;

import com.fssa.freshfood.exceptions.InvalidUserException;
import com.fssa.freshfood.exceptions.UserServiceException;
import com.fssa.freshfood.model.User;


public class TestUserService {
    private UserService userService;
    private UserDao userDao;

    @BeforeEach
    public void setUp() {
        userDao = new UserDao(); // Create a UserDao instance
        userService = new UserService();
       
    }

    @Test
    public void testCreateUserValidUser() throws Exception {
        User user = new User(
                "John",
                "Doe",
                "Chennai",
                "john@gmail.com",
                "1234567890",
                "600001",
                "Passw0rd@" 
            );
        
        boolean result = userService.createUser(user);
        assertTrue(result);
    }



    @Test
    public void testGetUserByEmailValidEmail() throws Exception {
        String validEmail =  "john@gmail.com";
        
        assertThrows(InvalidUserException.class, () -> {
        	userService.getUserByEmail(validEmail);
        });
       
      
    }

    @Test
    public void testGetUserByEmailInvalidEmail() throws Exception {
        String invalidEmail = "invalid@example.com";
        
        // Expecting an InvalidUserException when trying to get a non-existent user
        assertThrows(InvalidUserException.class, () -> {
            userService.getUserByEmail(invalidEmail);
        });
    }
}
