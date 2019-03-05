package com.example.eurekaServiceServer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceServer2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceServer2Application.class, args);
	}
}
