package com.sd.college.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.security.SecureRandom;
import java.util.Random;

@Service
public class Helper {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendFirstMail(String username,String email, String otp) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(email);
			helper.setSubject("Account Created");
			String htmlContent = "<!DOCTYPE html>\n" +
					"<html lang=\"en\">\n" +
					"\n" +
					"<head>\n" +
					"    <meta charset=\"UTF-8\">\n" +
					"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
					"    <title>OTP Email Template</title>\n" +
					"    <style>\n" +
					"        body {\n" +
					"            font-family: Arial, sans-serif;\n" +
					"            background-color: #f4f4f4;\n" +
					"            margin: 0;\n" +
					"            padding: 20px;\n" +
					"            display: flex;\n" +
					"            justify-content: center;\n" +
					"            align-items: center;\n" +
					"        }\n" +
					"        .email-container {\n" +
					"            background-color: #ffffff;\n" +
					"            border-radius: 8px;\n" +
					"            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n" +
					"            max-width: 600px;\n" +
					"            width: 100%;\n" +
					"            padding: 20px;\n" +
					"        }\n" +
					"        .header {\n" +
					"            text-align: center;\n" +
					"            padding-bottom: 20px;\n" +
					"            border-bottom: 1px solid #ddd;\n" +
					"        }\n" +
					"        .header h2 {\n" +
					"            color: #333;\n" +
					"        }\n" +
					"        .content {\n" +
					"            margin: 20px 0;\n" +
					"        }\n" +
					"        .otp {\n" +
					"            background-color: #e0f7fa;\n" +
					"            color: #00796b;\n" +
					"            font-size: 24px;\n" +
					"            padding: 10px;\n" +
					"            text-align: center;\n" +
					"            border-radius: 5px;\n" +
					"            margin: 20px 0;\n" +
					"        }\n" +
					"        .footer {\n" +
					"            text-align: center;\n" +
					"            color: #555;\n" +
					"            margin-top: 20px;\n" +
					"            font-size: 14px;\n" +
					"        }\n" +
					"    </style>\n" +
					"</head>\n" +
					"\n" +
					"<body>\n" +
					"    <div class=\"email-container\">\n" +
					"        <div class=\"header\">\n" +
					"            <h2>Welcome to CDA Project</h2>\n" +
					"        </div>\n" +
					"        <div class=\"content\">\n" +
					"            <p>Dear "+username+"</p>\n" +
					"            <p>Thank you for registering. Please use the following OTP to complete your account activation:</p>\n" +
					"            <div class=\"otp\">"+otp+"</div>\n" +
					"            <p>The OTP is valid for 10 minutes. If you did not request this, please ignore this email.</p>\n" +
					"        </div>\n" +
					"        <div class=\"footer\">\n" +
					"            <p>Best regards,</p>\n" +
					"            <p>Team CDA Project by SD</p>\n" +
					"        </div>\n" +
					"    </div>\n" +
					"</body>\n" +
					"\n" +
					"</html>";
//			String htmlContent = "" +
//					"<html> <body style='background:cyan;'> <p style='margin:auto; '> Here Is Your <b>" + otp
//					+ "</b> for CDA Project by SD</p>&nbsp&nbsp&nbsp" +
//					"<strong> YOU MAY GET JWT TOKEN IN FUTURE FOR ACTIVATE THE USER OPTION.. </body> </html>";
			helper.setText(htmlContent, true);
		} catch (MessagingException e) {
			System.out.println("Invalid Email Id");
			return false;
		}
		try {
			javaMailSender.send(mimeMessage);
		} catch (MailException e) {
			System.out.println("Invalid Email Id");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public int generateOTP() {
//		double otp = Math.random()*8999+1000;
		Random random = new SecureRandom();
		int otp = 100000 + random.nextInt(900000); // Generates a 6-digit OTP
//		return String.valueOf(otp);
		return (int) otp;
	}
	
	
}
