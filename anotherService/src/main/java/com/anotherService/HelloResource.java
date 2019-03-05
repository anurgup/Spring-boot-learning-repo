package com.anotherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by anurag on 16/08/18.
 */
@RestController
@ComponentScan("com.anotherService")
@RequestMapping("/rest/hello/client")
public class HelloResource {

    @Autowired
    private RestTemplate restTemplate;

   @GetMapping
   public String hello(){
        String url = "http://ItemCatalog:8766/rest/hello/server";
        return restTemplate.getForObject(url,String.class);
    }
}
