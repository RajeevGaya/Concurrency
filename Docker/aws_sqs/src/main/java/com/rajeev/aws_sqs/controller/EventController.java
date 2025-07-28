package com.rajeev.aws_sqs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajeev.aws_sqs.dto.Product;
import com.rajeev.aws_sqs.publisher.EventPublisher;
import com.rajeev.aws_sqs.service.ProductService;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/events")
public class EventController {

    private final ProductService productService;

    @Autowired
    public EventController(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    private EventPublisher eventPublisher;


    @PostMapping("/publish")
    public String publishRawObj(@RequestBody Product product) throws ExecutionException, InterruptedException {
        // productService.saveProduct(product);
        return eventPublisher.publishEvent(product);
    }

    @PostMapping("/publish1")
    public String publishRawObj1(@RequestBody Product product) throws ExecutionException, InterruptedException {
        productService.saveProduct(product);
        return eventPublisher.publishEvent1(product);
    }
}