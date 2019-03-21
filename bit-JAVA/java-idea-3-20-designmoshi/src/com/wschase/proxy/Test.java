package com.wschase.proxy;

import java.lang.reflect.Proxy;

/**代理设计模式：
 * 张三要给李四送花，找快递员代理
 * 快递员在给李四送花之前需要先打电话确认是否有人、然后送花、最后签收
 * Author:WSChase
 * Created:2019/3/20
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

class ProxyFirend implements SendFlower{
    public SendFlower sendFlower;

    public ProxyFirend(SendFlower sendFlower) {
        //这我们用接口后面实现向上转型，这样代码的可扩展性更强，
        //因为如果这样，我们后面既可以更换真正的业主，并不一定是这个。
        //只需要在工厂方法中返回值值就可以了。
        this.sendFlower = sendFlower;
    }

    @Override
    public void sendFlower() {
        this.telephone();
        this.sendFlower.sendFlower();
        this.writer();
    }

    private void writer() {
        System.out.println("收到花以后签收确认");
    }

    private void telephone() {
        System.out.println("先打电话确认");
    }
}

class Factory{
    public static SendFlower getInstance(){
        return new ProxyFirend(new BoyFirend());
    }
}

public class Test {
    public static void main(String[] args) {
        //返回的是真正的业主，这样我们在执行整整的方法是时候就是我们需要执行的业务
        SendFlower sendFlower=Factory.getInstance();
        sendFlower.sendFlower();
    }
}
