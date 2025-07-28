package com.rajeev.aws_sqs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajeev.aws_sqs.dto.Product;

public interface ProductRepository  extends JpaRepository<Product,Long> {
}