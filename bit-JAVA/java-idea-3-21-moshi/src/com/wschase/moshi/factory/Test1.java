package com.wschase.moshi.factory;

import java.io.File;
import java.util.Scanner;

/**简单工厂模式：买电脑的例子
 * Author:WSChase
 * Created:2019/3/21
 */
interface Computer{
     void printComputer();
}

class MacComputer implements Computer{

    @Override
    public void printComputer() {
        System.out.println("这是Mac电脑");
    }
}

class SurComputer implements Computer{

    @Override
    public void printComputer() {
        System.out.println("这是Sur电脑");
    }
}

//一个产生对象的工厂
class Factory{
    public static Computer getInstance(String type){
     Computer computer=null;
        if(type.equals("mac")){
            computer=new MacComputer();
        }else if(type.equals("sur")){
            computer=new SurComputer();
        }
        return computer;
    }
}
public class Test1 {
    public static void main(String[] args) {
        System.out.println("你想买什么电脑：【mac/sur】");
        Scanner scanner=new Scanner(System.in);
        String type=scanner.nextLine();
        Computer computer=Factory.getInstance(type);
        computer.printComputer();
    }

}
