package com.trustingsocial.restapi.status;

public enum AppStatus {
    RUNNING(200), 
    UNAUTHORIZED(401), 
    BAD_REQUEST(400),
    RATE_LIMIT(429), 
    FORBIDDEN(403);
    
	private final int code;

	AppStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	
}
