package com.megatravel.accservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccServiceApplication.class, args);
	}

}
