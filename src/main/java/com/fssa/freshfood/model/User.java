package com.fssa.freshfood.model;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String district;
    private String email;
    private String phoneNumber;
    private String pincode;
    private String password;

    // Constructor
    public User( String firstName, String lastName, String district, String email,
                String phoneNumber, String pincode, String password) {
      
        this.firstName = firstName;
        this.lastName = lastName;
        this.district = district;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pincode = pincode;
        this.password = password;
    }
    
    public User( int id, String firstName, String lastName, String district, String email,
            String phoneNumber, String pincode, String password) {
    	this(  firstName, lastName, district, email, phoneNumber, pincode, password);
    	this.id = id;
}

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", district='" + district + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", pincode='" + pincode + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
