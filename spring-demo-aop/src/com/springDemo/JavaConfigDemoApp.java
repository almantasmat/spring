package com.springDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
//        read spring config file

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
//        get the bean from spring container
        Coach coach = context.getBean("tennisCoach", Coach.class);
//        call a method of the bean
        System.out.println(coach.getDailyWorkOut());
        System.out.println(coach.getDailyFortune());
//        close the context
        context.close();
    }
}
