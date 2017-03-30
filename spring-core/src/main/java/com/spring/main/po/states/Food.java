package com.spring.main.po.states;

/**
 * Created by braveup on 2017/3/30.
 */
public interface Food {
     enum Coffee implements Food{
        BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO
    }
    enum Dessert implements Food{
        FRUIT, CAKE, GELATO
    }
}
