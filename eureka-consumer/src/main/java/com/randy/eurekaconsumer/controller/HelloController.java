package com.randy.eurekaconsumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/sayHello")
    public String sayHello() {
        log.info("consumer pipe");
       return restTemplate.getForObject("http://EUREKA-SERVICE/sayHello", String.class);
       // return restTemplate.getForObject("http://EUREKA-SERVICE/sayHelllo",String.class);
    }
}
