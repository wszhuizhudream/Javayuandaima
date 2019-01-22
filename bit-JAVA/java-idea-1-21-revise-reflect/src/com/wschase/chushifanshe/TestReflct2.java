package com.wschase.chushifanshe;

/**反射vs工厂模式
 * Author:WSChase
 * Created:2019/1/21
 */
interface IFruit{
    public void eat();
}

class Apple implements IFruit{

    @Override
    public void eat() {
        System.out.println("[Apple]吃苹果");
    }
}

class Orange implements IFruit{

    @Override
    public void eat() {
        System.out.println("[Orange]吃橘子");
    }
}

class FruitFactory{//这个是通过反射来获取对象的关键：通过传入我们需要对象的名字获取对象，但是我们不需要if来判断直接可以返回实例化对象
    private FruitFactory(){
    }

    public static IFruit getInstance(String className){
        IFruit fruit=null;
        try{
            fruit=(IFruit)Class.forName(className).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruit;
    }
}

public class TestReflct2 {
    public static void main(String[] args) {
        IFruit fruit=FruitFactory.getInstance("com.wschase.chushifanshe.Orange");
        fruit.eat();
    }
}
