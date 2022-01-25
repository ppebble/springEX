package com.spring.sample;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class ExampleAdvice implements MethodInterceptor{
	
	public Object invoke(MethodInvocation invocation) throws Throwable{
		System.out.println("start : " +invocation.getMethod().getName());
		Object obj = invocation.proceed();
		System.out.println("end : " + invocation.getMethod().getName());
		return obj;
	}

}
