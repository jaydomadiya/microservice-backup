package com.feginClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	ProxyForServerApp proxyForServerApp;
	
	@GetMapping(path = "/hello1")
	public String hello1() {
		System.out.println("test from hello1.... ");
		 String result = proxyForServerApp.callTest1();
		return "test from hello1.... !!  "+ " " + result;
	}
}
