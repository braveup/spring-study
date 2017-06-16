package com.spring.main.thread.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by braveup on 2017/6/16.
 */
@Service
public class ScheduledTaskService {


    private static  final SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
    //schedule声明该方法是一个计划任务，fixedRate指定每隔多长时间执行一次
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每隔五秒中执行一次："+format.format(new Date()));
    }

    //在指定的时间下执行，cron是Linux或者Uinux下的定时器
    @Scheduled(cron = "0 28 11 ? * *")
    public void fixTimeExecute(){
        System.out.println("在指定的时间下："+format.format(new Date())+"执行");
    }


}
