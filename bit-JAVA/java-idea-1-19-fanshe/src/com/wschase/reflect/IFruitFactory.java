package com.wschase.reflect;

/**
 * Author:WSChase
 * Created:2019/1/19
 */
public class IFruitFactory {
    private IFruitFactory(){

    }

    public static IFruit getIFruit(String furitName){
        if("apple".equalsIgnoreCase(furitName)){
            return new Apple();
        }
        if("orange".equalsIgnoreCase(furitName)){
            return new Orange();
        }
        throw new IllegalArgumentException(furitName+"not Found");
    }
}
