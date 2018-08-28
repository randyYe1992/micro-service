package com.randy.eurekaservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/sayHello")
    public String sayHello() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("host:"+instance.getHost()+" and serviceId:"+instance.getServiceId());
        return "Hello,eureka-servive";
    }
}
