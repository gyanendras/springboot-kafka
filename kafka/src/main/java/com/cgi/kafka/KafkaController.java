package com.cgi.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	
	@GetMapping("/sms/{msg}")
	public void sendMsg(@PathVariable String msg) {
		kafkaTemplate.send("topic1", msg)	;
		System.out.println("Message sent");
	}
	
	

}
