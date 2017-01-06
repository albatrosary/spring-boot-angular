package com.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogInterceptor {

    @Around("execution(public * com.example.*.HeroController.*(..))")
	public Object itemReaderAround(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();
		log.info("[{}] called.", methodName);
		Object object = joinPoint.proceed();
		return object;
	}
}
