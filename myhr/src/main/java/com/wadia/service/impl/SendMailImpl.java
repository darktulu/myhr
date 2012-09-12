package com.wadia.service.impl;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.wadia.local.Recipients;
import com.wadia.service.SendMail;

public class SendMailImpl implements SendMail {

	@Override
	public void sendMailHTML(List<Recipients> toMail, String title, String mail) {
		 final String username = "MyHR@3gcom-int.com";
	        final String password = "G3com123";

	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");

	        Session session = Session.getInstance(props,
	                new javax.mail.Authenticator() {

	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("MyHR@3gcom-int.com"));
	           
	            
	            /*message.setRecipients(Message.RecipientType.TO,
	                    InternetAddress.parse(toMail));*/
	            
	            
	            for (Recipients recipient : toMail) {
	            	
	            	RecipientType type = null;
	            	
	            	if ("To".equals(recipient.getType())) {
	            	
	            		type = (RecipientType) Message.RecipientType.TO;
	            		
	            	} else if ("Cc".equals(recipient.getType())) {
	            	
	            		type = (RecipientType) Message.RecipientType.CC;
	            		
	            	} else if ("Bcc".equals(recipient.getType())) {
	            	
	            		type = (RecipientType) Message.RecipientType.BCC;
	            	}
	            	
	            	message.addRecipients(type, InternetAddress.parse(recipient.getMail(), false));
	            
	            }
	            
	            message.setSubject(title);
	            message.setContent(mail, "text/html");
	            Transport.send(message);

	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }

	}

}
