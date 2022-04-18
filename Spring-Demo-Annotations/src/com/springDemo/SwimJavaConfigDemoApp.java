package com.springDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
//        read spring config file

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
//        get the bean from spring container
      SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
//        call a method of the bean
        System.out.println(coach.getDailyWorkOut());
        System.out.println(coach.getDailyFortune());
//        Call our swimCoach methods has the props values injected
        System.out.println("email: " + coach.getEmail() + "\n" + "team: " + coach.getTeam());
//        close the context
        context.close();
    }
}
