package com.parkhe.mail;

public interface Notification {
public boolean sendNotification(String toEmail, String subject, StringBuilder body, boolean ishtmlFormat);
public String getHost();

}
