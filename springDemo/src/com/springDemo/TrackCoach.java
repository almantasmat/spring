package com.springDemo;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;

    public TrackCoach(HappyFortuneService happyFortuneService) {
        this.fortuneService = happyFortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return "Run 3000 step all day";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
