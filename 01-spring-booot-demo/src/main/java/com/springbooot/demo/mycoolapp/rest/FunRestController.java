package com.springbooot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {
//    expose "/" that return "Hello world"
    @GetMapping("/")
    public String sayHello(){
        return "Hello world time on server is " + LocalDateTime.now();
    }
}
