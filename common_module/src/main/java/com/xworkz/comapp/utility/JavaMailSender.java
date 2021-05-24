package com.xworkz.comapp.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class JavaMailSender {

	@Autowired
	JavaMailSenderImpl mailSenderImpl;

	public void sendMail() {

		String[] bccs = { "sushma.nimbal98@gmail.com", "surakshita.xworkz@gmail.com" };
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("varsha.xworkz@gmail.com");
		message.setTo("rakshithar.xworkz@gmail.com", "varsha1998bh@gmail.com");
		message.setBcc(bccs);
		message.setSubject("Demo Mail Sender");
		message.setText("Hello Everyone, \n I am Varsha Hiremath \n From Xworkz \n this mail is for demo.");

		mailSenderImpl.send(message);
	}

}
