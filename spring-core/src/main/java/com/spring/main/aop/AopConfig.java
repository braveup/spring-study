package com.spring.main.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by braveup on 2017/6/14.
 */
@Configuration
@ComponentScan("com.*")
@EnableAspectJAutoProxy
public class AopConfig {

}

