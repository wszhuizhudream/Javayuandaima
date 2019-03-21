package com.wschase.moban;

/**模板设计模式：就是对于功能差不多的步骤我们提炼出来一个模板——核心是抽象类
 * 1.冲咖啡：
 * 将水煮沸
 * 用沸水冲泡咖啡
 * 将咖啡倒进杯子
 * 加糖和牛奶
 * 2.泡茶：
 * 将水煮沸
 * 用沸水冲泡茶
 * 将茶倒进杯中
 * 加柠檬
 * Author:WSChase
 * Created:2019/3/20
 */
abstract class Design{
   final void preparRecipe(){
       boilWater();
       brew();
       pourCup();
       add();
   }

    public abstract void add();

    public void pourCup(){
        System.out.println("倒进杯中");
    }

    public abstract void brew();

    public void boilWater(){
        System.out.println("将水煮沸");
    }

}

class Coffee extends Design{

    @Override
    public void add() {
        System.out.println("加糖和牛奶");
    }

    @Override
    public void brew() {

        System.out.println("用沸水冲泡咖啡");
    }
}
class Tea extends Design{

    @Override
    public void add() {
        System.out.println("加柠檬");
    }

    @Override
    public void brew() {

        System.out.println("用水冲泡茶");
    }
}
public class Test {
    public static void main(String[] args) {
        Design coffee=new Coffee();
        coffee.preparRecipe();
    }
}
