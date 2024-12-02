package com.jay.server_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	
	@GetMapping(path = "/test1")
	public String test1(){
		System.out.println("i am from test1...");
		return "i am from test1...";
	}

}
