package com.fssa.freshfood.validator;

import java.util.regex.Pattern;


import com.fssa.freshfood.exceptions.InvalidUserException;
import com.fssa.freshfood.model.User;



/**
 * The UserValidator class provides methods for validating user input data.
 */
public class UserValidator {

    /**
     * Validates a User object.
     *
     * @param user The User object to validate.
     * @return true if the User is valid, false otherwise.
     * @throws InvalidUserException if the User is invalid, with a descriptive error message.
     */
    public static boolean isValid(User user) throws InvalidUserException {
        if (user == null) {
            throw new InvalidUserException("User is null");
        }

        validateName(user.getFirstName(), "First Name");
        validateName(user.getLastName(), "Last Name");
        validateDistrict(user.getDistrict());
        validateEmail(user.getEmail());
        validatePhoneNumber(user.getPhoneNumber());
        validatePincode(user.getPincode());
        validatePassword(user.getPassword());

        return true;
    }

    /**
     * Validates a name field.
     *
     * @param name The name to validate.
     * @param fieldName The name of the field being validated (e.g., "First Name" or "Last Name").
     * @throws InvalidUserException if the name is empty or null.
     */
    private static void validateName(String name, String fieldName) throws InvalidUserException {
        if (name == null || name.isEmpty()) {
            throw new InvalidUserException(fieldName + " is required");
        }
        // Implement additional validation rules for names if needed
    }

    /**
     * Validates a district field.
     *
     * @param district The district to validate.
     * @throws InvalidUserException if the district is empty or null.
     */
    private static void validateDistrict(String district) throws InvalidUserException {
        if (district == null || district.isEmpty()) {
            throw new InvalidUserException("District is required");
        }
        // Implement additional validation rules for districts if needed
    }

    /**
     * Validates an email field.
     *
     * @param email The email to validate.
     * @throws InvalidUserException if the email is invalid.
     */
    private static void validateEmail(String email) throws InvalidUserException {
        if (email == null || !email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")) {
            throw new InvalidUserException("Invalid email format");
        }
    }

    /**
     * Validates a phone number field.
     *
     * @param phoneNumber The phone number to validate.
     * @throws InvalidUserException if the phone number is invalid.
     */
    private static void validatePhoneNumber(String phoneNumber) throws InvalidUserException {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new InvalidUserException("Invalid phone number format");
        }
    }

    /**
     * Validates a pincode field.
     *
     * @param pincode The pincode to validate.
     * @throws InvalidUserException if the pincode is invalid.
     */
    private static void validatePincode(String pincode) throws InvalidUserException {
        if (pincode == null || !pincode.matches("\\d{6}")) {
            throw new InvalidUserException("Invalid pincode format");
        }
    }

    /**
     * Validates a password field.
     *
     * @param password The password to validate.
     * @throws InvalidUserException if the password is empty, null, or does not meet the password requirements.
     */
    private static void validatePassword(String password) throws InvalidUserException {
        if (password == null || password.isEmpty()) {
            throw new InvalidUserException("Password is required");
        }
        
        // Define a regular expression pattern for the password requirements
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

        if (!password.matches(passwordPattern)) {
            throw new InvalidUserException("Password must meet the following requirements:\n" +
                    "- At least 8 characters long\n" +
                    "- Contains at least one uppercase letter\n" +
                    "- Contains at least one lowercase letter\n" +
                    "- Contains at least one digit\n" +
                    "- Contains at least one special character (@#$%^&+=!)\n" +
                    "- Does not contain whitespace");
        }
    }

}
