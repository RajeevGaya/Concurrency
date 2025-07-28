package com.rajeev.aws_sns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rajeev.aws_sns.dto.MessageEvents;
import com.rajeev.aws_sns.service.SnsDemoService;

@SpringBootApplication
@RestController
@RequestMapping("/sns")
public class AwsSnsApplication {

	@Autowired
	private SnsDemoService service;

	@GetMapping("/subscribe")
	public String enableSubscription(@RequestParam String protocol, @RequestParam String endpoint) {
		return service.autoSubscription(protocol, endpoint);
	}

	@PostMapping
	public String publishMessageToTopic(@RequestBody MessageEvents events) {
		return service.publishMessage(events.getEvent());
	}

	public static void main(String[] args) {
		SpringApplication.run(AwsSnsApplication.class, args);
	}

}
