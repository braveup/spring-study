package com.spring.main.service.enumstudy;

import com.spring.main.po.states.Food;

/**
 * Created by braveup on 2017/3/30.
 *
 */
public class IntefaceEnum implements Food {
    public static void main(String[] args) {

        for (Coffee coffee : Coffee.values()) {
            System.out.println(coffee);
        }
        show(Coffee.BLACK_COFFEE);
    }

    private static void show(Coffee blackCoffee) {
        switch (blackCoffee) {
            case BLACK_COFFEE:
                System.out.println(blackCoffee);
                break;
            case CAPPUCCINO:
                System.out.println(blackCoffee);
                break;
            case DECAF_COFFEE:
                System.out.println(blackCoffee);
                break;
            case LATTE:
                System.out.println(blackCoffee);

        }
    }

}
