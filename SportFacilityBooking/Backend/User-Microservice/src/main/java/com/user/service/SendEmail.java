package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendEmail {

	@Autowired
    private JavaMailSender javaMailSender;
	
	public void mailer(String email,String info) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("saurabh151@gmail.com");
        msg.setTo(email);
        msg.setSubject("noReply");
        msg.setText("Greetings, "+info);
        javaMailSender.send(msg);
        System.out.println("sent");

    }
}