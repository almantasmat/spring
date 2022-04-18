package com.springDemo;

public class BasketballCoach implements Coach {
    @Override
    public String getDailyWorkOut() {
        return "play basketbal at less 3h in day";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
