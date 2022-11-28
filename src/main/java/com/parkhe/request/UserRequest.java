package com.parkhe.request;

public class UserRequest {
	private String emailId, notification;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	@Override
	public String toString() {
		return "UserRequest [emailId=" + emailId + ", notification=" + notification + "]";
	}

}
