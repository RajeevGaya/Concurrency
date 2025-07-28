package com.rajeev.aws_sqs.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT_SQS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private Long productId;
    private String productName;
    private int quantity;
    private Double price;
    private Double discount;
    private Double totalAmount;
}
