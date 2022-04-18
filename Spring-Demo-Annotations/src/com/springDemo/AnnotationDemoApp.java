package com.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
//        read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        get the bean from spring container
        Coach coach = context.getBean("tennisCoach", Coach.class);
//        call a method of the bean
        System.out.println(coach.getDailyWorkOut());
        System.out.println(coach.getDailyFortune());
//        close the context
        context.close();
    }
}
