package com.rajeev.awsrds.service;

import com.rajeev.awsrds.entity.Product;
import com.rajeev.awsrds.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> saveBulkProducts(List<Product> products) {
        return (List<Product>) productRepository.saveAll(products);
    }
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }
}