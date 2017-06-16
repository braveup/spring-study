package com.spring.main.springAware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by braveup on 2017/6/16.
 */
public class MainActon {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Awareconfig.class);
        AwareService awareService = annotationConfigApplicationContext.getBean(AwareService.class);
        awareService.outputResult();
    }
}
