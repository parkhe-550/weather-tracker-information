package com.parkhe.messanger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkhe.alert.Alert;
import com.parkhe.api.response.WeatherResponse;
import com.parkhe.request.UserRequest;
@Service("messageSender")
public class MessageSender {
	@Autowired
	private Alert alert;
	public boolean sendMessage(UserRequest user, WeatherResponse status) {
		return alert.send(user.getEmailId(), "Weather Status", new StringBuilder(status.toString()), false);
	}
}
