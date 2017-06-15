package com.spring.main.springevent.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by braveup on 2017/6/15.
 *
 * Spring event 遵循以下流程
 *      （1）、自定义事件，继承ApplicationEvent
 *      （2）、定义事件监听器，实现ApplicationListener
 *      （3）、使用applicationContext 的postEvent发布事件
 */
//自定义事件
public class DemoEvent extends ApplicationEvent {

    private  String msg;
    public DemoEvent(Object source,String msg) {
        super(source);
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
