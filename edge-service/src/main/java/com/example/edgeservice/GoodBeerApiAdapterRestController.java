package com.example.edgeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import java.util.stream.*;

/**
 * Created by anurag on 05/03/19.
 */
@RestController
@ComponentScan("com.example.edgeservice")
@RequestMapping
class GoodBeerApiAdapterRestController {


    @GetMapping("/good-beers")
    public String goodBeers() {
        return "beers are really good";
    }

   /* @GetMapping("/testService")
    public String hello(){
        String url = "http://localhost:8080/employee/";
        return restTemplate.getForObject(url,String.class);
    }*/

    /*private boolean isGreat(Beer beer) {
        return !beer.getName().equals("Budweiser") &&
                !beer.getName().equals("Coors Light") &&
                !beer.getName().equals("PBR");
    }*/
}