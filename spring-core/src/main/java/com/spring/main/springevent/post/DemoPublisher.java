package com.spring.main.springevent.post;

import com.spring.main.springevent.event.DemoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * Created by braveup on 2017/6/15.
 */
//通过Spring的上下文发布事件
@Component
public class DemoPublisher {

    @Autowired
    private ApplicationContext  applicationContext;

    public void post(String msg){
        applicationContext.publishEvent(new DemoEvent(this,msg));
    }


}
