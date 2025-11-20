package com.ecommerce;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // ---- POINTCUTS ----

    // Pointcut #1: any method in UserService
    @Pointcut("execution(* com.ecommerce.model..*.*(..))")
    public void userServiceMethods() {}

    // Pointcut #2: any method with one String argument
    @Pointcut("args(java.lang.String) && userServiceMethods()")
    public void stringArgumentMethods() {}

    // Pointcut #3: any "get*" method
    @Pointcut("execution(* com.ecommerce.model..get*(..))")
    public void getterMethods() {}
    // ---- ADVICE METHODS ----

    // Advice #1: Before any UserService method
    @Before("userServiceMethods()")
    public void logBeforeUserService() {
        System.out.println("[Before] User's method called");
    }

    // Advice #2: After any get* method
    @AfterReturning(pointcut = "getterMethods()", returning = "result")
    public void logAfterGetter(Object result) {
        System.out.println("[AfterReturning] Getter returned: " + result);
    }

    // Advice #3: Around any method with a String argument
    @Around("stringArgumentMethods()")
    public Object logAroundStringMethods(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[Around] Before method with String argument");
        Object value = pjp.proceed();
        System.out.println("[Around] After method with String argument");
        return value;
    }
}
