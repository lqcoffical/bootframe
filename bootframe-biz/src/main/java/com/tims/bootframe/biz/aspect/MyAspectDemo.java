package com.tims.bootframe.biz.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * This is an aspect demo
 */
@Component
@Aspect
public class MyAspectDemo {

    //@Around("execution(* com.tims.bootframe.biz.service.impl.UserDemoServiceImpl.*(..))")
    @Around("@annotation(com.tims.bootframe.biz.annotation.Match)")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("环绕通知前");
        // 自己调用目标方法
        Object proceed = joinPoint.proceed();
        System.out.println("环绕通知后");
        return proceed;
    }

}
