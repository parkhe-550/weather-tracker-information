package com.parkhe.alert;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkhe.mail.Notification;
@Service("alert")
public class SendAlert extends Alert {
	@Autowired
	private Notification emailNotification;
	
	public boolean send(String receiver, String subject, StringBuilder body, boolean isHtmlFormat) {
		return emailNotification.sendNotification(receiver, subject, body, isHtmlFormat);
	}
}
