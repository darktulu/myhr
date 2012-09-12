package com.wadia.service;

import java.util.List;

import com.wadia.local.Recipients;

public interface SendMail {
	
	public void  sendMailHTML(List<Recipients> toMail, String title, String mail);

}
