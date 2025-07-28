package com.rajeev.aws_sqs.publisher;

import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rajeev.aws_sqs.dto.Product;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class EventPublisher {
    public static final String QUEUE_ENDPOINT = "https://sqs.us-east-1.amazonaws.com/569221301279/devops4dev-queue";
    public static final String DEVOPS_QUEUE_ENDPOINT = "https://sqs.us-east-1.amazonaws.com/569221301279/devops-queue";

    @Autowired
    private SqsTemplate sqsTemplate;

    public String publishEvent(Product product) throws ExecutionException, InterruptedException {
        CompletableFuture<SendResult<Product>> future = sqsTemplate.sendAsync(QUEUE_ENDPOINT, product);
        CompletableFuture<SendResult<Product>> future1 = sqsTemplate.sendAsync(DEVOPS_QUEUE_ENDPOINT, product);
        System.out.println("fut 1 :"+future1.get().messageId().toString());

        return "Message submitted to queue with ID " + future.get().messageId().toString();
    }

    public String publishEvent1(Product product) throws ExecutionException, InterruptedException {
        CompletableFuture<SendResult<Product>> future = sqsTemplate.sendAsync(DEVOPS_QUEUE_ENDPOINT, product);
        return "Message submitted to queue with ID " + future.get().messageId().toString();
    }
}
