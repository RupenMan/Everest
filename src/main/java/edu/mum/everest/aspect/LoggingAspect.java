package edu.mum.everest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("execution(* edu.mum.everest..*(..))")
	public void loggingMethod() {}
	
	@Pointcut("@annotation(edu.mum.everest.aspect.Logging)")
	public void aspectLogging() {}
	
	@Pointcut("args(obj)")
	public void argumentMethod(Object obj) {}

	@Before("loggingMethod() && aspectLogging() && args(obj)")
	public void loggingAspect(JoinPoint joinPoint, Object obj) {
		System.out.println(joinPoint.getSignature().getName()
				+" method of "+obj.getClass().getSimpleName() + " class invoked ...");
	}
	
	@After("loggingMethod() && aspectLogging() && args(obj)")
	public void afterLoggingAspect(JoinPoint joinPoint, Object obj) {
		System.out.println(joinPoint.getSignature().getName()
				+" method of "+obj.getClass().getSimpleName() + " class terminated ...");
	}
}
