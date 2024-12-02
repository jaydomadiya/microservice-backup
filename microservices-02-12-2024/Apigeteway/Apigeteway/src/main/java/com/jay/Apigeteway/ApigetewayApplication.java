package com.jay.Apigeteway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApigetewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigetewayApplication.class, args);
	}

}
