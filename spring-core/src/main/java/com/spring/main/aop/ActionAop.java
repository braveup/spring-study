package com.spring.main.aop;

import java.lang.annotation.*;

/**
 * Created by braveup on 2017/6/14.
 * 编写拦截规则的注解
 * 注解本身没有功能的，注解和xml文件类似是一种元数据，元数据就是一种解释性的数据，这就是所谓的配置
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ActionAop {
    String  name();
}
