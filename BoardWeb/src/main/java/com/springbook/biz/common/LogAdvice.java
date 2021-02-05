package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

@Service
@Aspect // Aspect = Pointcut + Advice
public class LogAdvice {
	
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {	
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[���� ó��] "+method+"() �޼ҵ� ARGS ���� : "+args[0].toString());
	}
	
	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() + " �α���(Admin)");
			}
			System.out.println("[���� ó��] "+method+"() �޼ҵ� ���� �� : "+returnObj.toString());
		}
	}
	
	public void exceptionLog(JoinPoint jp, Exception exceptObj){
		String method = jp.getSignature().getName();
		
		System.out.println("[���� ó��] "+method+"() �޼ҵ� ���� �� : "+exceptObj.toString());
	}
	
	public void printLog(JoinPoint jp) {
		System.out.println("[���� �α�] ����Ͻ� ���� ���� �� ����");
	}
}
