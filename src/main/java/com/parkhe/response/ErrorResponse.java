package com.parkhe.response;

public class ErrorResponse {
private String message;

public ErrorResponse(String message) {
	super();
	this.message = message;
}

public String getMessage() {
	return message;
}

}
