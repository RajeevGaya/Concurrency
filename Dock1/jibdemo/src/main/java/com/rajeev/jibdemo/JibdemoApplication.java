package com.rajeev.jibdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class JibdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JibdemoApplication.class, args);
	}

	@GetMapping("/test")
	public String getMethodName() {
		return "Hi";
	}
	

}
