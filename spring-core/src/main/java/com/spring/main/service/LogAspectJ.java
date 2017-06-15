package com.spring.main.service;

import com.spring.main.aop.ActionAop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by braveup on 2017/6/14.
 * 编写切面
 */
@org.aspectj.lang.annotation.Aspect
@Component
public class LogAspectJ {

    //定义切点
    @Pointcut("@annotation(com.spring.main.aop.ActionAop)")
    public void annotationPointCut() {
        System.out.println("进入切点Pointcut");
    };


    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ActionAop actionAop = method.getAnnotation(ActionAop.class);
        System.out.printf("注解式拦截" + actionAop.name());
    }


//   @Before("execution(*.com.spring.main.service.aop.DemoMethodService.*(..))")
//    public void before(JoinPoint joinPoint) {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//        System.out.println("方法规则式拦截" + method.getName());
//    }

}
