package com.spring.main.task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by braveup on 2017/3/18.
 */
public class QuartzJob {

    public void work(){
        System.out.println("Quartz的任务调度"+(new Date()).toString());
    }

    public  static  void main(String args[]){
        System.out.println("quartz start...");
        ApplicationContext  ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        //如果配置文件中将startQuartz bean的lazy-init设置为false 则不用实例化
        QuartzJob quartzJob= (QuartzJob) ctx.getBean("myJob");
        quartzJob.work();
        System.out.printf("请输入信息:");
        Scanner  input=new Scanner(System.in);
        int x=input.nextInt();
        System.out.println(x);
        System.out.println("quartz end...");
    }

}
