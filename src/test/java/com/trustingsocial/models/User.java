package com.trustingsocial.models;

import com.trustingsocial.restapi.builders.UserBuilder;

public class User {
	
	private String user_name;
	private String password;
	private String email;
	private String phone_number;
	
   public User(UserBuilder builder) {
	   this.user_name = builder.getUserName();
	   this.password = builder.getPassword();
	   this.email = builder.getEmail();
	   this.phone_number = builder.getPhoneNumber();
    }
	
	public String getUserName() {
		return user_name;
	}
	public void setUserName(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phone_number;
	}
	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}
	
	@Override
    public String toString() {
        return "User{" +
                "user_name='" + user_name + '\'' +
                ", passwrod='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
