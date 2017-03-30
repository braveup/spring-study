package com.spring.main;

import com.spring.main.aop.AspectAnnotationTest;
import com.spring.main.aop.Performer;
import com.spring.main.po.Helloword;
import com.spring.main.service.Aspect;
import com.spring.main.service.interfaceImpl.AServiceImpl;
import com.spring.main.service.interfaceImpl.BServiceImpl;
import com.spring.main.service.interfaces.IAService;
import com.spring.main.service.interfaces.IBService;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by braveup on 2017/2/16.
 */
public class MianApplication {
    private static final Logger LOGGER = Logger.getLogger(MianApplication.class);

    //    public static void main(String args[]) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        BeanFactory factory = context;
//        Helloword helloword = (Helloword) factory.getBean("helloword");
//        LOGGER.info("MianApplication {} ==>" + "MainApplication name:" + helloword.getName() + "MainApplication age:"+ helloword.getAge());
//        System.out.println("age:" + helloword.getAge() + "\b" + "name:" + helloword.getName());
//    }
//    public static void main(String[] args) {
//        Date dateb = new Date(System.currentTimeMillis() - 3600000 * (14 - 1));
//        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.printf("dateb:"+myFmt.format(dateb));
//    }
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-aop.xml");
//        Performer performer = (Performer) context.getBean("DukePerformers");
//        performer.perform();
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        IAService aService= (IAService) context.getBean("aService");
//        aService.fooA("s");

//        ApplicationContext contexts = new ClassPathXmlApplicationContext("applicationContext.xml");
//        IBService bService= (IBService) contexts.getBean("bService");
//        bService.fooB();
        ApplicationContext context=new ClassPathXmlApplicationContext("config/dev/aop-annotiontest.xml");
        IBService bService= (IBService) context.getBean("bService");
        bService.fooB(2);
    }

}
