package org.alalgo.usc.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Aspect
@Component
@Slf4j
public class CommonAspect {
	@Around("org.alalgo.usc.aspects.CommonPointCut.serviceLayer()")
	public Object  countTime(ProceedingJoinPoint pjp) throws Throwable {
		long begin = System.currentTimeMillis();
		 Object retVal = pjp.proceed();
		 log.debug( pjp.getSignature().getDeclaringTypeName()+"."+pjp.getSignature().getName() + " 耗时："+ (System.currentTimeMillis()-begin));
		 return retVal;
	}
}
