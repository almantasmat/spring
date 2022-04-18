package com.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeanScopeDemoApp {

    public static void main(String[] args) {
        //uzkrauti spring konfiguracijos faila
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScopeAplicationContext.xml");
        //Gauti beana is spring Konteinerio (context'o)
       Coach coach = context.getBean("myCoach", Coach.class);
        Coach coach1 = context.getBean("myCoach", Coach.class);

        boolean result = (coach == coach1);

        System.out.println("Pointing to the same objeckt " + result);
        System.out.println("Memory locatio for coach " + coach);
        System.out.println("Memory location for coach1 " + coach1);
        context.close();
    }


}
