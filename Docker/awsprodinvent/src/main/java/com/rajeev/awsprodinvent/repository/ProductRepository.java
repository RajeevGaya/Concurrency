package com.rajeev.awsprodinvent.repository;

import com.rajeev.awsprodinvent.entity.Product;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ProductRepository  extends CrudRepository<Product,String> {
}