package com.spring.main.po.states;

/**
 * Created by braveup on 2017/3/30.
 * 1、枚举的本质是类，在没有枚举之前，仍然可以按照java最基本的编程手段来解决需要用到枚举的地方。
 * 枚举屏蔽了枚举值的类型信息，不像在用public static final定义变量必须指定类型。
 * 枚举是用来构建常量数据结构的模板，这个模板可扩展。枚举的使用增强了程序的健壮性，
 * 比如在引用一个不存在的枚举值的时候，编译器会报错。枚举的更多用法还需要在开发中去研究创造，
 * Java5、Java6增加了不少新的特性，技术在升级，对程序员来说就要学习，
 * 如果你热爱java的话。否则别人用到新特性的代码你看不懂，那才叫郁闷。
 * 2、枚举在Java家族中只占了很小的一块比重，所以我在项目中用枚举的地方不是很多，
 * 毕竟，一个项目是很多人开发维护的，用一个陌生的东西，会给其他的同事造成阅读困难。
 * 所以常量大都是用public static final 来定义的。
 * JDK1.6之前的switch语句只支持int,char,enum类型，使用枚举，能让我们的代码可读性更强。
 */
public enum CustomEnum {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);

    // 成员变量
    private String name;
    private int index;

    // 构造方法，初始化枚举类型的对应关系
    CustomEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法,根据值去匹配名称
    public static String getName(int index) {
        for (CustomEnum customEnum : CustomEnum.values()) {
            if (customEnum.getIndex() == index)
                return customEnum.name;
        }
        return null;
    }

    /**
     *用法四：覆盖枚举的方法
     * @return
     */
    public String toString(){
        return this.index+""+this.name;
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
}
