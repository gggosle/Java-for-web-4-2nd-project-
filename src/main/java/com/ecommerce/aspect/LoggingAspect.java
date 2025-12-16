package com.ecommerce.aspect;

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

    @Pointcut("execution(* com.ecommerce.model..*.*(..))")
    public void userServiceMethods() {}

    @Pointcut("args(java.lang.String) && userServiceMethods()")
    public void stringArgumentMethods() {}

    @Pointcut("execution(* com.ecommerce.model..get*(..))")
    public void getterMethods() {}

    @Before("userServiceMethods()")
    public void logBeforeUserService() {
        System.out.println("[Before] User's method called");
    }

    @AfterReturning(pointcut = "getterMethods()", returning = "result")
    public void logAfterGetter(Object result) {
        System.out.println("[AfterReturning] Getter returned: " + result);
    }

    @Around("stringArgumentMethods()")
    public Object logAroundStringMethods(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[Around] Before method with String argument");
        Object value = pjp.proceed();
        System.out.println("[Around] After method with String argument");
        return value;
    }
}
