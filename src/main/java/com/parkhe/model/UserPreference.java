package com.parkhe.model;

public class UserPreference {
	private String notification;

	public UserPreference(String notification) {
		super();
		this.notification = notification;
	}

	public UserPreference() {
		super();
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}
	
}
