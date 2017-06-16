package com.spring.main.thread.springTaskExecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by braveup on 2017/6/16.
 */
public class MainAction {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        ThreadExecutorService threadExecutorService = applicationContext.getBean(ThreadExecutorService.class);

        for(int i=0;i<10;i++){
            threadExecutorService.executeTaskPool(i);
            threadExecutorService.executeTaskPoolPlus(i);
        }

        applicationContext.close();
    }
}
