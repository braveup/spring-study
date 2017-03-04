package com.spring.main.service.interfaceImpl;

import com.spring.main.service.interfaces.IBService;

/**
 * Created by braveup on 2017/2/23.
 * 使用cglib代理（默认使用）
 */
public class BServiceImpl implements IBService {
    public void fooB(int e) {
        System.out.println("BServiceImpl testB() ...");
        if (e==1){
            throw new IllegalArgumentException("测试异常");
        }
    }

    public void testB(String msg,int type) {
        System.out.println("BServiceImpl.fooB(msg"+msg+")");
        if (type==1){
            throw new IllegalArgumentException("发生异常的情况");
        }
    }

}
