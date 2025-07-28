package com.rajeev.jenkins_ci_cd;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class JenkinsCiCdApplication {

	public static void main(String[] args) {
		SpringApplication.run(JenkinsCiCdApplication.class, args);
	}

	@GetMapping("/test")
	public String getMethodName(@RequestParam String name) {
		return "Hi "+new Date()+".."+name;
	}
	@GetMapping("/")
	public String test() {
		return "Hi";
	}

}
