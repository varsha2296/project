package com.xworkz.comapp.utility;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class JavaMailSender {

	public static void main(String[] args) {
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		mailSenderImpl.setHost("smtp.gmail.com");
		mailSenderImpl.setPort(587);
		mailSenderImpl.setUsername("varsha.xworkz@gmail.com");
		mailSenderImpl.setPassword("");

		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.debug", "true");

		mailSenderImpl.setJavaMailProperties(javaMailProperties);

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
