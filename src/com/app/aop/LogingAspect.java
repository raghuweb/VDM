package com.app.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogingAspect {
	
	/*//enable log4j .. logger obj
	private Log log=LogFactory.getLog(getClass());
	
	
	@Pointcut("execution(public * com.app..*.*(..))")
	public void point1(){}
	
	@Around("point1()")
	public Object showTime(ProceedingJoinPoint jp){
		StopWatch watch=new StopWatch(jp.getTarget().getClass().getName());
		
		Object ob=null;
		try {
			watch.start(jp.getSignature().getName());
			ob = jp.proceed();
			watch.stop();
		} catch (Throwable e) {
		}
		log.info(watch.prettyPrint());
		return ob;
	}
	@AfterThrowing(pointcut="point1()",throwing="th")
	public void getProblems(Throwable th){
		log.error("Fail:"+th);
	}
	@AfterReturning(pointcut="point1()",returning="ob")
	public void getSuccessData(Object ob){
		log.debug("Success:"+ob);
		
	}
*/
}
