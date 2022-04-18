package com.springDemo;

public class CricketCoatch implements Coach {
    private String emailAddress;
    private String team;
    private FortuneService fortuneService;

    public CricketCoatch() {

    }

    public void setFortuneService(FortuneService fortuneService) {
       this.fortuneService = fortuneService;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return this.team;
    }


    @Override
    public String getDailyWorkOut() {
        return "run run";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
