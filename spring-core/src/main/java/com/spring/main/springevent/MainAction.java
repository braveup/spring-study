package com.spring.main.springevent;

import com.spring.main.springevent.config.EventConfig;
import com.spring.main.springevent.post.DemoPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by braveup on 2017/6/15.
 */
public class MainAction {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher demoPublisher = configApplicationContext.getBean(DemoPublisher.class);
        demoPublisher.post("hello word  ......");
    }

}
