package com.example.bookstoreconsumer.listener;

import com.example.bookstoreconsumer.constant.KafkaConstant;
import com.example.bookstoreconsumer.model.Email;
import com.example.bookstoreconsumer.model.Purchase;
import com.example.bookstoreconsumer.service.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {

    @Autowired
    EmailService emailService;

    @KafkaListener(id = "foo", topics = KafkaConstant.KAFKA_TOPIC)
    public void listener(String foo) throws JsonProcessingException {

        Purchase purchase = new ObjectMapper().readValue(foo, Purchase.class);
        String mailBody = "Hello, " + purchase.getMember().getFirstName() + " your order has been processed. Here is your invoice :\n\n"
                        + "Transaction ID : Rp." + purchase.getId() + "\n"
                        + "Grand Total : " + purchase.getGrandTotal() + "\n"
                        + "Purchase Details :\n" + purchase.getPurchaseDetailsString();

//        System.out.println(foo);

        Email email = new Email(purchase.getMember().getEmail(), "inezamanda02@gmail.com", "Enigma Book Store - Transaction Notification", mailBody);
        emailService.sendEmail(email);
    }

}
