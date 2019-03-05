package com.anotherService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * Created by anurag on 16/08/18.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AnotherServiceDefinition {

    public static void main(String[] args) {
        SpringApplication.run(AnotherServiceDefinition.class, args);
    }
}

