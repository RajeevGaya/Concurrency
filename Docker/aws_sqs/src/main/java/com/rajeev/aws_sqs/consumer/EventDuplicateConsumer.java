package com.rajeev.aws_sqs.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.rajeev.aws_sqs.dto.Product;

@Component
public class EventDuplicateConsumer {

    @SqsListener("devops4dev-queue")
    public void consumeMessage(@Payload Product product) {
        System.out.println("Received event message in EventDuplicateConsumer : "+product);
        // Add your message processing logic here
        //populate events to database (dynamodb | RDS (MySQL))
    }


}