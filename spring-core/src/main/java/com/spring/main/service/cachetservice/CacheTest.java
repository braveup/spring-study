package com.spring.main.service.cachetservice;

import org.springframework.cache.annotation.Cacheable;

/**
 * spring 的缓存注解学习
 * Created by braveup on 2017/3/15.
 */
public class CacheTest {
    public static void main(String[] args) {
        System.out.println( new CacheTest().test()+" "+ new CacheTest().test1()+" "+ new CacheTest().test2());
    }
    @Cacheable("databaseCache")
    public int test(){
        return 2;
    }
    @Cacheable("databaseCache")
    public int test1(){
        return 3;
    }
    @Cacheable("databaseCache")
    public int test2(){
        return 4;
    }

}
