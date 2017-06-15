package com.spring.main.service.aop;

import com.spring.main.aop.ActionAop;
import org.springframework.stereotype.Service;

/**
 * Created by braveup on 2017/6/14.\
 * \\
 * 编写使用注解的被拦截的类
 */
@Service
public class DemoAnnotationService {
    @ActionAop(name = "的add()操作")
    public void add() {
        System.out.println("已经被拦截了");
    };
}
