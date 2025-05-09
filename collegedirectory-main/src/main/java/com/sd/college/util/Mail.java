package com.sd.college.util;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class Mail {
	
		@Value("${app.password}")
		private String appPassword;
		@Bean
		JavaMailSender javaMailSender()
		{
			JavaMailSenderImpl jmsi = new JavaMailSenderImpl();
			
			jmsi.setHost("smtp.gmail.com");
			jmsi.setPort(587);
			jmsi.setUsername("somitdas001element");
			jmsi.setPassword(appPassword);
					
			Properties props = jmsi.getJavaMailProperties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.debug", "true");
			
			return jmsi;
		}
	
}
