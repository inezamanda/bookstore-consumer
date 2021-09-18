package com.example.bookstoreconsumer.listener;

import com.example.bookstoreconsumer.model.Email;
import com.example.bookstoreconsumer.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {

    @Autowired
    EmailService emailService;

    @KafkaListener(id = "foo", topics = "enigma-bookstore")
    public void listener(String foo) {
        System.out.println(foo);
        Email email = new Email("inez.amanda16@gmail.com", "inezamanda02@gmail.com", "Enigma Book Store - Transaction Notification", foo);
        emailService.sendEmail(email);
    }

}
