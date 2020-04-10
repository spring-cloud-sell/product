package com.cczhilie.edu.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * Created by HH on 2020/4/8.
 */
@RestController
@Slf4j
public class ServerController {

    @Value("${env}")
    private String evn;



    @GetMapping("/getMsg")
    public String getMsg(){
        return evn;
    }
}
