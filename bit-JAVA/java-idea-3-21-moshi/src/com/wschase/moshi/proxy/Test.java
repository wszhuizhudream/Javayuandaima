package com.wschase.moshi.proxy;

/**代理设计模式——送花的例子
 * Author:WSChase
 * Created:2019/3/21
 */
interface SendFlower{
    void sendFlower();
}

class BoyFirend implements SendFlower{

    @Override
    public void sendFlower() {
        System.out.println("张三给李四送花");
    }
}

class Proxy implements SendFlower{
   public  SendFlower sendPeople;

   public Proxy(SendFlower sendPeople){
       this.sendPeople=sendPeople;
   }

    @Override
    public void sendFlower() {
        this.telephone();
        this.sendPeople.sendFlower();
        this.sure();
    }

    private void telephone() {
        System.out.println("送花之前进行确认");
    }

    private void sure() {
        System.out.println("签字确认");
    }
}

//也可以将返回一个对象作为工厂方法
public class Test {
    public static void main(String[] args) {
        SendFlower realPeople=new Proxy(new BoyFirend());
        realPeople.sendFlower();

    }
}
