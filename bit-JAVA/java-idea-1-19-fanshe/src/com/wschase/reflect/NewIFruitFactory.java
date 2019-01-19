package com.wschase.reflect;

/**
 * Author:WSChase
 * Created:2019/1/19
 */
public class NewIFruitFactory {

    private NewIFruitFactory(){

    }
    public static IFruit getIFruit(String className){

        try {
            Class c=Class.forName(className);
            try {
                return (IFruit) c.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException(className+"not Found");
    }
}
