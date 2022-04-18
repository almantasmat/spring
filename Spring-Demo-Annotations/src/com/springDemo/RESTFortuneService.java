package com.springDemo;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "You break a hand soon";
    }
}
