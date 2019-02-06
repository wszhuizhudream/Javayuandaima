package com.bittech.reflect.tfdp;

/**
 * Author: secondriver
 * Created: 2019/1/18
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
@Fruit(target = Orange.class)
public class AnnotationIFruitFactory {
    
    public static IFruit getInstance() {
        Fruit annotation = AnnotationIFruitFactory.class.getAnnotation(Fruit.class);
        try {
            return (IFruit) annotation.target().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public static void main(String[] args) {
        
        AnnotationIFruitFactory.getInstance().eat();
        
    }
}

