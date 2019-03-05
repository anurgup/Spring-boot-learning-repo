package com.example.edgeservice;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by anurag on 05/03/19.
 */
@Configuration
@ComponentScan("com.example.edgeservice")
public class AppConfig {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
//        MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
//        converter.setObjectMapper(new ObjectMapper());
//        restTemplate.getMessageConverters().add(converter);
        return restTemplate;
    }
}