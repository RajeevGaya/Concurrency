package com.rajeev.awsrds.repository;

import com.rajeev.awsrds.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Integer> {
}