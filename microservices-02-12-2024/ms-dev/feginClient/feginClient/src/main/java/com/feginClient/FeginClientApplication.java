package com.feginClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.feginClient")
public class FeginClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeginClientApplication.class, args);
	}

}
