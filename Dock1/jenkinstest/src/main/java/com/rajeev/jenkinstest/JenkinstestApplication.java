package com.rajeev.jenkinstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class JenkinstestApplication {

	@GetMapping("/")
	public String getMethodName() {
		return "Rajeev Singh";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(JenkinstestApplication.class, args);
	}

}
