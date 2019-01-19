package com.wschase.reflect;

/**
 * Author:WSChase
 * Created:2019/1/19
 */
public class TestFruit {
    public static void main(String[] args) {
        if(args.length==1){
            String fruitName=args[0];
            IFruit fruit=IFruitFactory.getIFruit(fruitName);
            fruit.eate();
        }else {
            System.out.println("你没有输入参数");
        }
    }
}
