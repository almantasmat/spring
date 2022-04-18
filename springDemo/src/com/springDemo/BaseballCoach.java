package com.springDemo;

public class BaseballCoach implements Coach {
    //    apibrezti private tipo kintamaji prkiklausomybei
    private FortuneService fortuneService;

    //    atlikti priklausomybiu injekcija per konstruktoriu
    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return "Spend 30 min on batching practis";
    }

    @Override
    public String getDailyFortune() {
//     panaudosime fortune service kad gautume fortuna
        return fortuneService.getFortune();
    }
//    prideti init metoda
    public  void doMyStartupStaff(){
        System.out.println("baseballCoach:inside method soMyStartupStaff");
    }
    //pridedadme destroy metod
    public void doMyCleanupStaff(){
        System.out.println("baseballCoach: inside method doMyCleanupStuff");
    }
}
