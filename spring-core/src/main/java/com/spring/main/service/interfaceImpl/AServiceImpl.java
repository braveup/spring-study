package com.spring.main.service.interfaceImpl;

import com.spring.main.service.interfaces.IAService;

/**
 * Created by braveup on 2017/2/23.
 * 使用JDK动态代理
 */
public class AServiceImpl implements IAService {
    private String  msg;


    public void testA() {
        System.out.println("AServiceImpl.testA(msg+"+msg+")");
    }

    public void fooA(String msg) {
        System.out.println("AServiceImpl.fooA(msg+"+msg+")");
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
