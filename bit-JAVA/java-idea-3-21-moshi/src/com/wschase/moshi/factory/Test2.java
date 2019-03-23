package com.wschase.moshi.factory;

import com.wschase.moshi.moban.Test;

/**工厂方法模式
 * Author:WSChase
 * Created:2019/3/21
 */
interface Computer2{
    void printComputer2();
}

class MacComputer2 implements Computer2{

    @Override
    public void printComputer2() {
        System.out.println("这是mac电脑");
    }
}

class SurComputer2 implements Computer2{

    @Override
    public void printComputer2() {
        System.out.println("这是sur电脑");
    }
}

class MacFactory{
    public static MacComputer getMac(){
        return new MacComputer();
    }
}

class SurFactory {
    public static SurComputer getSur(){
        return new SurComputer();
    }
}
public class Test2 {
    public void buyComputer(Computer computer){
        computer.printComputer();
    }
    public static void main(String[] args) {
        Computer computer=SurFactory.getSur();
        Test2 test2=new Test2();
        test2.buyComputer(computer);
    }
}
