package com.spring.main.po.states;

/**
 * Created by braveup on 2017/3/30.
 * 用法五：实现接口
 * 所有的枚举都继承自java.lang.Enum类。由于Java 不支持多继承，所以枚举对象不能再继承其他类。
 */
public enum IntefaceEnum implements Behaviour {

    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);

    // 成员变量
    private String name;
    private int index;

    IntefaceEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public void print() {
        System.out.println(this.index + ":" + this.name);
    }

    @Override
    public String getInfo() {
        return this.name;
    }
}
