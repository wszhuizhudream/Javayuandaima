package com.bittech.reflect.tfdp;

/**
 * Author: secondriver
 * Created: 2019/1/17
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class IFruitFactory {
    
    private IFruitFactory() {
    
    }
    
    public static IFruit getIFruit(String fruitName) {
        if ("apple".equalsIgnoreCase(fruitName)) {
            return new Apple();
        }
        if ("orange".equalsIgnoreCase(fruitName)) {
            return new Orange();
        }
        throw new IllegalArgumentException(fruitName + " not found");
    }
}
