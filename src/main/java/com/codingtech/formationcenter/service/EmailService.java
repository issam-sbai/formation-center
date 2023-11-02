package com.codingtech.formationcenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendUserRegistrationEmail(String to, String password) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject("Welcome to MyApp");
        mailMessage.setText("Your account has been created with the following credentials:\n\nEmail: " + to + "\nPassword: " + password);
        javaMailSender.send(mailMessage);
    }
}
