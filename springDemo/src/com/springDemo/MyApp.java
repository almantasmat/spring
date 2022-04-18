package com.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        //uzkrauti spring konfiguracijos faila
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Gauti beana is spring Konteinerio (context'o)
      BaseballCoach coatch = context.getBean("myCoach", BaseballCoach.class);
      CricketCoatch coatch1 = context.getBean("myCriketCoach", CricketCoatch.class);
        //kreipti i beano metoda
        System.out.println(coatch.getDailyWorkOut());
        System.out.println(coatch.getDailyFortune());
//     kviesime konkrecius metodus gauti konkreciom reiksmems
        System.out.println(coatch1.getDailyWorkOut());
        System.out.println(coatch1.getDailyFortune());
       System.out.println(coatch1.getEmailAddress());
        //uzdaryti contexta
        context.close();
//        sukiurti objekta
//        panaudoti objekta

        ;
    }
}
