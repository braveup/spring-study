package com.spring.main.aop;

import com.spring.main.service.aop.DemoAnnotationService;
import com.spring.main.service.aop.DemoMethodService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by braveup on 2017/6/14.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService demoAnnotationService = annotationConfigApplicationContext.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = annotationConfigApplicationContext.getBean(DemoMethodService.class);
        demoAnnotationService.add();
        demoMethodService.add();
        annotationConfigApplicationContext.close();
    }
}
