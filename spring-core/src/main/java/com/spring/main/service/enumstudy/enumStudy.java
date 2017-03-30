package com.spring.main.service.enumstudy;

import com.spring.main.po.states.ConstantEnum;
import com.spring.main.po.states.CustomEnum;

/**
 * 枚举（enum）类型是Java 5新增的特性，它是一种新的类型，
 * 允许用常量来表示特定的数据片断，而且全部都以类型安全的形式来表示
 * Created by braveup on 2017/3/30.
 */
public class enumStudy {
    public static void main(String[] args) {
        System.out.println(isRed(ConstantEnum.RED));
        showColor(ConstantEnum.RED);
        /**
         * 自定义的枚举类型
         */
        System.out.println(CustomEnum.RED.getName());
        System.out.println(CustomEnum.RED.getIndex());

        for (CustomEnum color: CustomEnum.values()){
            System.out.println(color+"name"+color.getName()+"index"+color.getIndex());
        }

    }

    private static void showColor(ConstantEnum red) {
        switch (red){
            case BLANK:
                System.out.println(red);
                break;
            case GREEN:
                System.out.println(red);
                break;
            case RED:
                System.out.println(red);
                break;
            case TELLOW:
                System.out.println(red);
                break;

        }
    }

    private static boolean isRed(ConstantEnum red) {
        if (ConstantEnum.RED.equals(red)){
            return  true;
        }
        return  false;
    }



}
