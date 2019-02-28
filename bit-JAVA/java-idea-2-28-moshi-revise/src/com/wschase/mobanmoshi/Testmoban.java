package com.wschase.mobanmoshi;

/**模板设计模式——抽象类的定义与具体使用
 * 模板设计模式是针对于两个过程非常相似，我们将它们相同的地方
 * 抽象出来将不同的地方法定义玮抽象方法这样就可以通过子类类分别实现。
 * 练习：
 * 1.冲咖啡：
 * （1）将水煮沸
 * （2）用沸水冲泡咖啡
 * （3)将已经泡好的咖啡倒入杯中
 * （4)加糖或牛奶
 * 2.泡茶：
 * （1）将水煮沸
 * （2）将茶叶用水浸泡
 * （3）将泡好的茶水倒入杯中
 * （4）加入柠檬
 * 分析：
 * 通过分析我们可以发现它们的前三个步骤都是相同的，只是在最后一个过程中加入的东西不同了
 * Author:WSChase
 * Created:2019/2/27
 */
public class Testmoban {
    public static void main(String[] args) {

        System.out.println("冲一杯咖啡：");
        Coffee coffee=new Coffee();
        coffee.prepar();

        System.out.println("------------");

        System.out.println("泡一杯茶：");
        Tea tea=new Tea();
        tea.prepar();
    }
}
