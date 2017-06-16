package com.spring.main.thread.springTaskExecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by braveup on 2017/6/16.
 *
 * 任务执行类
 */
@Service
public class ThreadExecutorService {

    @Async //声明此方法为异步方法
    public void executeTaskPool(Integer integer){
        System.out.println("执行异步任务:"+integer);
    }

    @Async //此方法为异步方法，如果在方法上标注的话整个类的方法都为异步的
    public void executeTaskPoolPlus(Integer integer){
        System.out.println("执行异步任务+1:"+(integer+1));
    }

}
