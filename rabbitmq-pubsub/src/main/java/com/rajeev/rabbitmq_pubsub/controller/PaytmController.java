package com.rajeev.rabbitmq_pubsub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajeev.rabbitmq_pubsub.dto.PaymentRequest;
import com.rajeev.rabbitmq_pubsub.publisher.PaytmPublisher;

@RestController
public class PaytmController {

    @Autowired
    private PaytmPublisher publisher;

    @PostMapping("/mq/pay")
    public String payUsingUPI(@RequestBody PaymentRequest request) {
        publisher.doPaymentTransaction(request);
        return "payment request in process !!";
    }
}