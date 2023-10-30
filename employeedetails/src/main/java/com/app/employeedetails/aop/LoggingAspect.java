package com.app.employeedetails.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* com.app.employeedetails.controller..*(..)) || execution(* com.app.employeedetails.service..*(..))")
    public void controllerAndServiceMethods() {}

    @Before("controllerAndServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Inside method :: " + joinPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "controllerAndServiceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("End of method: " + joinPoint.getSignature().toShortString() +" :: "+result);
    }

    @AfterThrowing(pointcut = "controllerAndServiceMethods()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        log.error("Exception in method: " + joinPoint.getSignature().toShortString(), exception);
    }
}
