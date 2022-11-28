package com.parkhe.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;
@Service("emailNotification")
public class EmailNotification implements Notification {
	private String sender = "";
	private String password = "";

	@Override
	public boolean sendNotification(String toEmail, String subject, StringBuilder body, boolean isHtmlFormat) {

		Session session = getAuthentication();
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject(subject);
			if (isHtmlFormat) {
				MimeBodyPart mimeBodyPart = new MimeBodyPart();
				mimeBodyPart.setContent(body.toString(), "text/html; charset=utf-8");

				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(mimeBodyPart);
				message.setContent(multipart);
			} else {
				message.setText(body.toString());
			}

			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return false;
		}
		return true;
	}

	private Properties getProperties() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", getHost());
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		return properties;
	}

	@Override
	public String getHost() {
		return "smtp.gmail.com";
	}

	private Session getAuthentication() {
		return Session.getInstance(getProperties(), new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, password);
			}
		});
	}
}
