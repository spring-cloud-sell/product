package com.cczhilie.edu.product.controller;

import com.cczhilie.edu.product.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: GZC
 * @create: 2020-04-09 16:47
 * @description:
 **/
@RestController
public class GirlController {

    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("/girl/print")
    public String print(){
        return "name: " + girlConfig.getName() + "，age: " + girlConfig.getAge();
    }
}
