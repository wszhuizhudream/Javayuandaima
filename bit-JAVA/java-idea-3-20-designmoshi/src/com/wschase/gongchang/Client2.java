package com.wschase.gongchang;

/**工厂方法模式
 * Author:WSChase
 * Created:2019/3/20
 */
interface Computer1{
    void printComputer1();
}
class MacProComputer implements Computer1{

    @Override
    public void printComputer1() {
        System.out.println("这是MacComputer");
    }
}
class SurComputer1 implements Computer1{

    @Override
    public void printComputer1() {
        System.out.println("这是SurComputer");
    }
}
interface ComputerFactory1{
    Computer1 createComputer();
}
class MacFactory implements ComputerFactory1{

    @Override
    public Computer1 createComputer() {
        return new MacProComputer();
    }
}

class SurFactory implements ComputerFactory1{

    @Override
    public Computer1 createComputer() {
        return new SurComputer1();
    }
}
public class Client2 {
    public void buyComputer1(Computer1 computer1){
        computer1.printComputer1();
    }
    public static void main(String[] args) {
        Client2 client2=new Client2();
        ComputerFactory1 factory1=new MacFactory();
        client2.buyComputer1(factory1.createComputer());
    }
}
