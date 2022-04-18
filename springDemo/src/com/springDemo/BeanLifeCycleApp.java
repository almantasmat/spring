package com.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeanLifeCycleApp {

    public static void main(String[] args) {
        //uzkrauti spring konfiguracijos faila
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifeCycle.xml");
        //Gauti beana is spring Konteinerio (context'o)
        Coach coach = context.getBean("myCoach", Coach.class);
        System.out.println(coach.getDailyFortune());
        context.close();
    }


}
