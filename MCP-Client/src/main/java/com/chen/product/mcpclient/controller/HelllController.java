package com.chen.product.mcpclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelllController {
    @RequestMapping("/world")
    public String helloWorld() {
        return "Hello World";
    }
}
