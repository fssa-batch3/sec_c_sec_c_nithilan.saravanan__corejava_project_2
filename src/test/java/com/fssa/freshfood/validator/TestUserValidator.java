package com.fssa.freshfood.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.fssa.freshfood.exceptions.InvalidUserException;
import com.fssa.freshfood.model.User;

public class TestUserValidator {

    @Test
    public void testValidUser() {
        // Create a valid user for testing
        User user = new User(
            "John",
            "Doe",
            "Chennai",
            "john.doe@example.com",
            "1234567890",
            "600001",
            "Passw0rd@"
        );

        try {
            boolean isValid = UserValidator.isValid(user);
            assertTrue("Valid user should return true", isValid);
        } catch (InvalidUserException e) {
            fail("Valid user should not throw an exception");
        }
    }

    @Test
    public void testInvalidUserMissingEmail() {
        // Create an invalid user with a missing email
        User user = new User(
            "Jane",
            "Doe",
            "Chennai",
            null, // Invalid email
            "1234567890",
            "600001",
            "Passw0rd@"
        );

        try {
            boolean isValid = UserValidator.isValid(user);
            assertFalse("User with missing email should return false", isValid);
        } catch (InvalidUserException e) {
            assertEquals("Invalid email format", e.getMessage());
        }
    }

    @Test
    public void testInvalidUserInvalidPhoneNumber() {
        // Create an invalid user with an invalid phone number
        User user = new User(
            "Bob",
            "Smith",
            "Chennai",
            "bob.smith@example.com",
            "12345", // Invalid phone number format
            "600001",
            "Passw0rd@"
        );

        try {
            boolean isValid = UserValidator.isValid(user);
            assertFalse("User with invalid phone number should return false", isValid);
        } catch (InvalidUserException e) {
            assertEquals("Invalid phone number format", e.getMessage());
        }
    }

    @Test
    public void testInvalidUserInvalidPassword() {
        // Create an invalid user with an invalid password
        User user = new User(
            "Alice",
            "Johnson",
            "Chennai",
            "alice.johnson@example.com",
            "1234567890",
            "600001",
            "password123" // Invalid password format
        );

        try {
            boolean isValid = UserValidator.isValid(user);
            assertFalse("User with invalid password should return false", isValid);
        } catch (InvalidUserException e) {
            assertTrue(e.getMessage().contains("Password must meet the following requirements"));
        }
    }
}
