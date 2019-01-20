package com.bittech.reflect.tfdp;

/**
 * Author: secondriver
 * Created: 2019/1/17
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class NewIFruitFactory {
    
    private NewIFruitFactory() {
    }
    public static IFruit getIFruit(String className) {
        try {
            Class c = Class.forName(className);
            return (IFruit) c.newInstance();
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(className + " not found.");
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("Instance " + className + " failed");
        }
    }
}
