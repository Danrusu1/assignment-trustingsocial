package com.trustingsocial.restapi.builders;

import com.trustingsocial.models.User;
import com.trustingsocial.restapi.interfaces.Builder;

public class UserBuilder implements Builder<User> {

	private String user_name;
	private String password;
	private String email;
	private String phone_number;

	private UserBuilder(String user_name) {
		this.user_name = user_name;
	}

	public static UserBuilder named(String user_name) {
		return new UserBuilder(user_name);
	}

	public UserBuilder withPassword(String password) {
		this.password = password;
		return this;
	}
	
	public UserBuilder withEmail(String email) {
		this.email = email;
		return this;
	}
	
	public User withPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
		return build();
	}
	
	// Getter
	public String getUserName() {
		return user_name;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phone_number;
	}

	@Override
	public User build() {
		return new User(this);
	}

}
