package com.trustingsocial.restapi.util;

public enum WebServiceEndPoints {
	
	CREATE_USER("/user/create"), 
	USER_LOGIN("/user/login"),
	USER_UPDATE("/user/update");

	private final String uri;

	WebServiceEndPoints(String uri) {
		this.uri = uri;
	}

	public String getUri() {
		return uri;
	}
}
