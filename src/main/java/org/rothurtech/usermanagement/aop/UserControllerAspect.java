package org.rothurtech.usermanagement.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.rothurtech.usermanagement.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserControllerAspect {
    Logger logger = LoggerFactory.getLogger(UserControllerAspect.class);

    //all UserController's methods
    @Pointcut("execution(* org.rothurtech.usermanagement.controller.UserController.*(..))")
    public void pointcut(){};

    //before all methods in UserController execute
    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        logger.info("Before method invoked::{}", joinPoint.getSignature());
    }

    //only execute after UserController.getUser executed
    @After("execution(* org.rothurtech.usermanagement.controller.UserController.getUser(..))")
    public void after( JoinPoint joinPoint ){
        logger.info("After method invoked::{}", joinPoint.getSignature());
    }
}
