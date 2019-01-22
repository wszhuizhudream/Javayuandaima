package com.wschase.chushifanshe;

/**反射vs工厂模式：练习
 * Author:WSChase
 * Created:2019/1/21
 */
interface IFruit1{
    public void eat();
}

class Apple1 implements IFruit1{

    @Override
    public void eat() {
        System.out.println("[Apple1]吃苹果");
    }
}

class Orange1 implements IFruit1{

    @Override
    public void eat() {
        System.out.println("[Orange1]吃橘子");
    }
}
class Strawberry implements IFruit1{

    @Override
    public void eat() {
        System.out.println("[Strawberry]吃草莓");
    }
}

class IFruitFactory1{

    //无参构造方法
    public IFruitFactory1() {
    }

    //创建一个方法来获取对象
    public static IFruit1 getInstance1(String name){
        //通过传入一个类的名字返回这个类的实例化对象，这样的功能只有反射可以实现
        IFruit1 fruit1=null;
        try{
            fruit1= (IFruit1) Class.forName(name).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruit1;
    }

}
public class TestReflct3 {
    public static void main(String[] args) {
        IFruit1 fruit1= (IFruit1) IFruitFactory1.getInstance1("com.wschase.chushifanshe.Apple1");
        fruit1.eat();
    }
}
