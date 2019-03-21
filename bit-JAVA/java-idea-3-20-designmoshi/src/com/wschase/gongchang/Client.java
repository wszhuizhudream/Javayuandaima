package com.wschase.gongchang;

import java.util.Scanner;

/**工厂设计模式
 * Author:WSChase
 * Created:2019/3/20
 */
interface Computer{
    //这个相当于是生产电脑的生产方法
    void printComputer();
}
class MacComputer implements Computer{

    @Override
    public void printComputer() {
        System.out.println("这是MacComputer");
    }
}

class SurComputer implements Computer{

    @Override
    public void printComputer() {
        System.out.println("这是SurComputer");
    }
}

class ComputerFactory{
    public static Computer getComputer(String type){
        Computer computer=null;
        if(type.equals("mac")){
            computer=new MacComputer();
        }else if(type.equals("sur")){
            computer=new SurComputer();
        }
        return computer;
    }
}

public class Client {
    //我们直接将买电脑封装成一个方法
    public void buyComputer(Computer computer){
        computer.printComputer();
    }

    public static void main(String[] args) {
        Client client=new Client();
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入您想要的电脑：[sur/mac]");
        String type=scanner.nextLine();
        Computer computer=ComputerFactory.getComputer(type);
        client.buyComputer(computer);
    }
}
