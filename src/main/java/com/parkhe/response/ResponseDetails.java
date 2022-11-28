package com.parkhe.response;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class ResponseDetails {
	private Object data;
	private String message;
	private int status;
	private Map<String, Object> element;

	public ResponseDetails(Object data, String message, int status) {
		super();
		this.data = data;
		this.message = message;
		this.status = status;
	}

	public ResponseDetails(Object data, String message, int status, Map<String, Object> element) {
		super();
		this.data = data;
		this.message = message;
		this.status = status;
		this.element = element;
	}

	public ResponseDetails(Object data, HttpStatus status) {
		this(data, status.name(), status.value());
	}

	public Object getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}

	public Map<String, Object> getElement() {
		if(element == null) {
			element = new LinkedHashMap<>();
		}
		return element;
	}
}
