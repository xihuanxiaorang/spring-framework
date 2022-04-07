package top.xiaorang.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author liulei
 * 正常通知：前置通知 ===> 目标方法 ===> 返回通知 ===> 后置通知
 * 异常通知：前置通知 ===> 目标方法 ===> 异常通知 ===> 后置通知
 * try{
 * 前置通知;
 * 目标方法;
 * 返回通知;
 * } catch(Exception e) {
 * 异常通知;
 * } finally {
 * 后置通知;
 * }
 */
@Component
@Aspect
public class LogAspect {
	@Pointcut("execution(* *(..))")
	public void pointcut() {
	}

	@Around("pointcut()")
	public Object aroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("--------------PreLog--------------");
		Object proceed = proceedingJoinPoint.proceed();
		System.out.println("--------------AfterLog--------------");
		return proceed;
	}
}
