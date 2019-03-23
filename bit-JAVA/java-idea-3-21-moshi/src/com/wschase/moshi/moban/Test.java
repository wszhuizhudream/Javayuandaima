package com.wschase.moshi.moban;

import java.util.Scanner;

/**模板设计——冲咖啡、泡茶
 * Author:WSChase
 * Created:2019/3/21
 */
abstract class Subserice{
    public void sub(){
        //将水烧开
        boilWater();
        //用水冲泡
        chongpao();

        //将已经冲泡好的倒进杯中
        putCup();
        //添加东西
        add();

    }

    abstract void add();

    public  void putCup(){
        System.out.println("将已经冲泡好的倒进杯中");
    }


    abstract void chongpao();

    public  void boilWater(){
        System.out.println("将水烧开");
    }

}

class Coffee extends Subserice{

    @Override
    void add() {
        System.out.println("加糖或牛奶");
    }

    @Override
    void chongpao() {

        System.out.println("用沸水冲泡咖啡");
    }
}

class Tea extends Subserice{

    @Override
    void add() {
        System.out.println("添加柠檬");
    }

    @Override
    void chongpao() {

        System.out.println("用沸水冲泡茶");
    }
}
//我们将产生对象封装成一个工厂方法，这个思想和代理模式是一样的，这样就可以实现用户想要什么我们就给什么
class Factory{
    public static Subserice getInstance(String type){
        Subserice subserice=null;//必须得先声明
        if(type.equals("coffee")){
         subserice=new Coffee();
        }else if(type.equals("tea")){
            subserice=new Tea();
        }
        return subserice;
    }
}
public class Test {
    public static void main(String[] args) {
        System.out.println("请输入您先要的饮料：【coffee/tea】");
        Scanner scanner=new Scanner(System.in);
        String type=scanner.nextLine();
        Subserice subserice=Factory.getInstance(type);
        subserice.sub();
    }
}
