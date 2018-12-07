package com.bittech.design;

import sun.security.smartcardio.SunPCSC;

import java.util.Scanner;
import java.util.function.BiFunction;

/**
 * 在java中一共有几种重要的设计模式：
 * 1.模板设计模式
 * 2.工厂设计模式：（1）简单工厂模式（2）工厂方法模式（3）抽象工厂方法模式
 * 3.代理模式
 * 4.单例设计模式
 * Author:WSChase
 * Created:2018/11/28
 */
////1.简单工厂设计模式
//interface Clothes{
//        void print();
//}
//class A implements Clothes{
//    @Override
//    public void print() {
//        System.out.println("这是A款式的衣服");
//    }
//}
//class B implements Clothes{
//    @Override
//    public void print() {
//        System.out.println("这是B款式衣服");
//    }
//}
//class ClotheFactory{//这个是生产衣服的工厂
//        public static Clothes getInstance(String type){
//            Clothes clothes=null;
//            if(type.equals("A")){
//                clothes=new A ();
//            }
//            if(type.equals("B")){
//                clothes=new B ();
//            }
//            return clothes;
//        }
//}
//public class Design {
//    public void buyClothes(Clothes clothes){
//        clothes.print();
//    }
//
//    public static void main(String[] args) {
//    Design ds=new Design();
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("请输入你想要的衣服款式：A/B");
//        String type=scanner.nextLine();
//        ds.buyClothes(ClotheFactory.getInstance(type));
//    }
//
//}


////2.工厂方法设计模式
//interface Clothes{
//    void print();
//}
//class A implements Clothes{
//    @Override
//    public void print() {
//        System.out.println("这是款式A的衣服");
//    }
//}
//class B implements Clothes{
//    @Override
//    public void print() {
//        System.out.println("这是B款式的衣服");
//    }
//}
////这个接口专门是用来实现实例化对象的
//interface ClothesFactory{
//     Clothes createFactory();
//}
//class AFactory implements ClothesFactory{
//    public Clothes createFactory(){
//        return new A();
//    }
//}
//class BFactory implements ClothesFactory{
//   public Clothes createFactory(){
//        return new B();
//    }
//}
//public class Design{
//    //这个方法专门是用来调用创建对象后对应的具体的方法
//public void buyClothes(Clothes clothes){
//    clothes.print();
//}
//    public static void main(String[] args) {
//        Design ds=new Design();
//        //首先需要调用对应的工厂方法生产一个对象，然后才能用这个对象去实现它的方法。
//        ClothesFactory cf=new AFactory();//在创建工厂的时候也是实现的向上转型
//        Clothes c=cf.createFactory();//得到对应的对象
//        ds.buyClothes(c);//调用接口的方法，但其实质是哪个类实现的调用的是哪个类的方法，打印对应的生产对象
//    }
//}

//3.抽象方法工厂:其实质就是将工厂方法进行了扩充
interface Computer{
    void print();
}
class Acomputer implements Computer{
    @Override
    public void print() {
        System.out.println("这是A电脑");
    }
}
class Bcomputer implements Computer{
    @Override
    public void print() {
        System.out.println("这是B电脑");
    }
}
interface OperateSystem{
    void use();
}
class AOperateSystem implements OperateSystem{
    @Override
    public void use() {
        System.out.println("这是A的操作系统");
    }
}
class BOperateSystem implements OperateSystem{
    @Override
    public void use() {
        System.out.println("这是B的操作系统");
    }
}
//对于这两个属性都分别创建各自的生产工厂
interface ComputerFactory{
    Computer createComputer();
}
class AComputerFactory implements ComputerFactory{
    @Override
    public Computer createComputer() {
        return new Acomputer();
    }
}
class BComputerFactory implements ComputerFactory{
    @Override
    public Computer createComputer() {
        return new Bcomputer();
    }
}
interface OperateSystemFactory{
    OperateSystem createOperateSystem();
}
class AOperateSystemFactory implements OperateSystemFactory{
    @Override
    public OperateSystem createOperateSystem() {
        return new AOperateSystem();
    }
}
class BOperateSystemFactory implements OperateSystemFactory{
    @Override
    public OperateSystem createOperateSystem() {
        return new BOperateSystem();
    }
}
public class Design{
    public void buyComputer(Computer computer){
        computer.print();
    }
    public void buyOprateSystem(OperateSystem operateSystem){
        operateSystem.use();
    }

    public static void main(String[] args) {
        Design ds=new Design();
        //要分别调用不同的方法
        //(1)生产一个电脑，有电脑的工厂方法->你需要的是哪种电脑
        ComputerFactory cf=new AComputerFactory();//->接口的对象去实现接口的方法，然后调用接口的方法
        OperateSystemFactory op=new BOperateSystemFactory();//->接口的对象去实现接口的方法，然后调用接口的方法
        ds.buyComputer(cf.createComputer());
        ds.buyOprateSystem(op.createOperateSystem());
    }
}