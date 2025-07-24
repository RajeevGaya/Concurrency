package com.rajeev.rabbitmq_pubsub.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajeev.rabbitmq_pubsub.config.MessagingConfig;
import com.rajeev.rabbitmq_pubsub.dto.PaymentRequest;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PaytmClientApp3 {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void processPaymentRequest(PaymentRequest request) {
        try {
            System.out.println("consumer (3) consumes : " + new ObjectMapper().writeValueAsString(request));

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
