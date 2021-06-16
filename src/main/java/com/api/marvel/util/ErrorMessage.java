package com.api.marvel.util;

public enum ErrorMessage {

	LIMIT_GREATHER_THAN_0("You must pass an integer limit greater than 0."), 
	MAY_NOT_REQUEST_MORE_THAN_100("You may not request more than 100 items."), 
	UNRECOGNIZED_ORDERING_PARAMETER("You must pass and valid ordering parameter."), 
	CHARACTER_NOT_FOUND("We couldn't find that character");

	private final String message;
	
	private ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
