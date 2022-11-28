package com.parkhe.service;

import com.parkhe.model.UserDetails;

public interface UserDetailsService {
	UserDetails searchUser(String emailId);

	void createUser(UserDetails details);
}
