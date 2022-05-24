package com.nchudinov.keygen.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSender {

	@Value("${spring.mail.username}")
	private String username;

	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendMessage(String emailTo, String subject, String message) {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			mailMessage.setFrom(username);
			mailMessage.setTo(emailTo);
			mailMessage.setSubject(subject);
			mailMessage.setText(message);

			mailSender.send(mailMessage);
			return true;
		} catch (MailException e) {
			return false;
		}
	}
	
	
}
