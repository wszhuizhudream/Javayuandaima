package com.bittech.reflect.tfdp;

/**
 * Author: secondriver
 * Created: 2019/1/17
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class TestFruitFactory {
    public static void main(String[] args) {
        if (args.length == 1) {
            String fruitName = args[0];
            IFruit fruit = NewIFruitFactory.getIFruit(fruitName);
            fruit.eat();
        } else {
            System.out.println("程序没有输入参数");
        }
    }
}
