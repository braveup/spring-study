package com.spring.main.aop;

/**
 * Created by braveup on 2017/2/23.
 */
public class DukePerformers implements Performer {
    private  String  str;
    public void perform() {
        System.out.println("str:"+str);
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
