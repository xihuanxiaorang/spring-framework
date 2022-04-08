package top.xiaorang.spring.aop;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

public class LogInterceptor {
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println(
				"Before ========>" +
						"The method " + methodName + " begins with " + Arrays.asList(joinPoint.getArgs()));
	}

	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("After ========>" + "The method " + methodName + " ends");
	}

	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("AfterReturning ========>" + "The method " + methodName + " ends with " + result);
	}

	public void afterThrowing(JoinPoint joinPoint, Exception e) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("AfterThrowing ========>" + "The method " + methodName + " occurs excetion:" + e);
	}
}
