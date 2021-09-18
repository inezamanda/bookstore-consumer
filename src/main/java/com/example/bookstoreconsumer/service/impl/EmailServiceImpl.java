package com.example.bookstoreconsumer.service.impl;

import com.example.bookstoreconsumer.model.Email;
import com.example.bookstoreconsumer.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendEmail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getEmailFrom());
        message.setTo(email.getEmailTo());
        message.setSubject(email.getEmailSubject());
        message.setText(email.getEmailBody());

        mailSender.send(message);
    }
}
