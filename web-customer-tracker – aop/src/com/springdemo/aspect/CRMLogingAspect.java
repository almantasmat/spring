package com.springdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLogingAspect {
//set up logger
    private Logger logger = Logger.getLogger(getClass().getName());
//    set up point cut declaration
    @Pointcut("execution(* com.springdemo.controller.*.*(..))")
    private void forControllerPackage(){ }

    @Pointcut("execution(* com.springdemo.service.*.*(..))")
    private void forServicePackage(){ }

    @Pointcut("execution(* com.springdemo.dao.*.*(..))")
    private void forDaoPackage(){ }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){

    }
//add @Before advice

    @Before("forAppFlow()")
    public void befor(JoinPoint joinPoint){
//        display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.severe("=====>> in @Before: calling method:" + method);
//        get arguments
        Object[] args=joinPoint.getArgs();
//        loop and display args
        for (Object o: args){
            logger.info("===========>>> argument: " + o);
        }
    }
//    add @afterReturning advice
    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
//        display method we are returning form
        String method = joinPoint.getSignature().toShortString();
        logger.info("========================>>>>>> in @After returning: from method: " + method);
//        display date return
        logger.info("===.>> result: " + result);
    }
}
