package com.springDemo;

public class SadFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return " So sad day";
    }
}
