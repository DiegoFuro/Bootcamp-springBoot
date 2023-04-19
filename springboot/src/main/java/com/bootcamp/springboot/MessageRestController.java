package com.bootcamp.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/api/v1")
public class MessageRestController {
	
	@Autowired
	private MessageService service;

	@GetMapping(value = "/message")
	public String hola() {
		return service.getMessage();
	}
}
