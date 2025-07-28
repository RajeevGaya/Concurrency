package com.example.awstest;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class AwstestApplication {

@GetMapping("/{name}")
public String getMethodName(@PathVariable String name) {
    return "Hi "+name+" "+new Date();
}


	public static void main(String[] args) {
		SpringApplication.run(AwstestApplication.class, args);
	}

}
