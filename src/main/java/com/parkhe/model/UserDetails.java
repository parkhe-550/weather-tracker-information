package com.parkhe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.parkhe.request.UserRequest;

public class UserDetails {
	private String emailId;
	private UserPreference preference;

	public UserDetails() {
		super();
	}

	public UserDetails(String emailId) {
		super();
		this.emailId = emailId;
	}

	public UserDetails(String emailId, UserPreference preference) {
		super();
		this.emailId = emailId;
		this.preference = preference;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public UserPreference getPreference() {
		return preference;
	}

	public void setPreference(UserPreference preference) {
		this.preference = preference;
	}

	@Override
	public String toString() {
		return emailId;
	}

	@JsonIgnore
	public static UserDetails getDetails(UserRequest request) {
		return new UserDetails(request.getEmailId(), new UserPreference(request.getNotification()));
	}

}
