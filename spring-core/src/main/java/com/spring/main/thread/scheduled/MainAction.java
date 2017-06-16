package com.spring.main.thread.scheduled;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by braveup on 2017/6/16.
 */
public class MainAction {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(ScheduledTaskConfig.class);
        ScheduledTaskService scheduledTaskService = configApplicationContext.getBean(ScheduledTaskService.class);
        scheduledTaskService.fixTimeExecute();//定时执行
        scheduledTaskService.reportCurrentTime();//每隔多长时间执行
    }
}
