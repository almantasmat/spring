package com.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component //("thatSillyCoach")
//@Scope("singleton")
//@Scope("prototype")
public class TennisCoach implements Coach {
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyWorkOut() {
        return "Practice your hand skills";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }


//    public void setFortuneService(FortuneService fortuneService){
//        this.fortuneService = fortuneService;
//    }
//    //vykdo pries compiliavimo metiu pries pradedant veikti programai
    @Autowired
    @Qualifier("RESTFortuneService")//nurodo kuria klase naudosim FortuneService interfeisui vykdyti
    public  void doSomeCrazyStuf(FortuneService fortuneService){
        System.out.println("inside doSomeCrazyStuff method");
        System.out.println(fortuneService.getFortune());
    }
//    define my init. method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("TennisCoach: inside doMyStartupStaff");
    }
//    define my destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("TennisCoach: inside doMyCleanupStuff");
    }
}
