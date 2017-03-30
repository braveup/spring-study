package com.spring.main.service;


import org.apache.log4j.Logger;
import org.aspectj.lang.*;

/**
 * Created by braveup on 2017/2/23
 * 切面类
 */
public class Aspect {
    private static final Logger logger = Logger.getLogger(Aspect.class);

    public void doAfter(JoinPoint joinpoint) {
        logger.info("into doafter aspect...");
        System.out.println("log Ending method" + joinpoint.getTarget().getClass().getName() + "." + joinpoint.getSignature().getName());
    }

    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("into DoAround aspect...");
        long time=System.currentTimeMillis();
        Object retVal=proceedingJoinPoint.proceed();
        time=System.currentTimeMillis()-time;
        System.out.println("proceed time"+time);
        return  retVal;
    }

    public void  doBefore(JoinPoint joinPoint){
        logger.info("into dobefore aspect ...");
        System.out.println("log Begining method" +joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName());
    }
    public  void  doThrowing(JoinPoint joinPoint,Throwable throwable){
        logger.info("into doThrowing aspect...");
        System.out.println("method"+joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName()+"Throw exception");
        System.out.println(throwable.getMessage());
    }
}
