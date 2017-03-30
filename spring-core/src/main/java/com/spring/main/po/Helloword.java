package com.spring.main.po;

/**
 * Created by braveup on 2017/2/20.
 */
public class Helloword {

    private String name;
    private int  age;

    /**
     * 构造注入
     * @return
     */
    public Helloword(String name) {
        this.name = name;
    }

    public Helloword() {

    }

    /**
     * 设值注入
     * 设值注入是指 IoC 容器使用属性的 setting 方法来注入被依赖的实例。
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
