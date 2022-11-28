package com.parkhe.alert;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.parkhe.mail.Notification;

public abstract class Alert {
	public abstract boolean send(String receiver, String subject, StringBuilder body, boolean isHtmlFormat);
}
