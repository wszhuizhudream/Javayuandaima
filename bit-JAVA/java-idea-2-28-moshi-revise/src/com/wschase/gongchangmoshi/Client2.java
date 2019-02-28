package com.wschase.gongchangmoshi;

/**工厂方法模式
 * 前面的简单工厂模式是多个类有共同的工厂类，
 * 但是工厂方法模式是每一个类都对应一个工厂类，生产产品。
 * Author:WSChase
 * Created:2019/2/28
 */
interface Clothes2{
     void print2();
}

class A2 implements Clothes2{

    @Override
    public void print2() {
        System.out.println("这是A款衣服");
    }
}

class B2 implements Clothes2{

    @Override
    public void print2() {
        System.out.println("这是A款衣服");
    }
}

//定义一个接口的工厂
interface ClothesFactory2{
     Clothes2 createClothes();
}

class AFactory implements ClothesFactory2{

    @Override
    public Clothes2 createClothes() {
        return new A2();
    }
}

class BFactory implements ClothesFactory2{

    @Override
    public Clothes2 createClothes() {
        return new B2();
    }
}
public class Client2 {
    public void buyClothes(Clothes2 clothes2){
        clothes2.print2();
    }
    public static void main(String[] args) {
        Client2 client2=new Client2();
        ClothesFactory2 factory2=new AFactory();
        client2.buyClothes(factory2.createClothes());
    }
}
