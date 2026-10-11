package com.chen.product.mcpclient;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class ServicelogAspect {
    @Around("execution(* com.chen.product.mcpclient.service.impl.*.*(..))")
    public Object logServiceMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Service method called: {}", joinPoint.getSignature());
        log.info("Service method arguments: {}", joinPoint.getArgs());
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        if (endTime-startTime > 3000) {
            log.info("Service method took too long {} ms", endTime - startTime);
        }
        if (endTime-startTime > 2000) {
            log.info("Service method took long {} ms", endTime - startTime);
        }
        log.info("Service method returned: {} in {} ms", result, endTime - startTime);
        return result;
    }
}
