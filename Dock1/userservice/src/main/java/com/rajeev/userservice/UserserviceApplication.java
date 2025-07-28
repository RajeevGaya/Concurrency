package com.rajeev.userservice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@RestController
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@GetMapping("/greeting")
	public String getMethodName() {
		return "K8s demo page";
	}

	@GetMapping("/users")
	public List<User> getusers() {
		return Stream.of( new User(24, "Rajeev"),new User(32, "Mahesh"), new User(45, "roit")).collect(Collectors.toList());
	
	}

}
