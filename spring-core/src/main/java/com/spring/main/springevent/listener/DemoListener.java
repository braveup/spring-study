package com.spring.main.springevent.listener;

import com.spring.main.springevent.event.DemoEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by braveup on 2017/6/15.
 */
//自定义事件监听器
@Component
public class DemoListener implements ApplicationListener<DemoEvent>{



    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {

        String msg=demoEvent.getMsg();

        System.out.println("接收到了发布事件消息"+msg);

    }
}
