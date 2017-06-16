package com.spring.main.thread.scheduled;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by braveup on 2017/6/16.
 */

@Configuration
@ComponentScan("com.spring.main.thread")
@EnableScheduling//开启对计划任务的支持
public class ScheduledTaskConfig {
}
