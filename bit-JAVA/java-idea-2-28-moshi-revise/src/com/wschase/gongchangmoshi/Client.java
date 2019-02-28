package com.wschase.gongchangmoshi;

import java.util.Scanner;

/**简单工厂模式
 * 练习：
 * 刘同学准备去买衣服，她到商场以后发现衣服有两个牌子
 * 她都特别喜欢，一款是A，另外一款是B。
 * Author:WSChase
 * Created:2019/2/28
 */
interface Clothes{
    public void print();
}

class A implements Clothes{

    @Override
    public void print() {
        System.out.println("这是A款衣服");
    }
}

class B implements Clothes{

    @Override
    public void print() {
        System.out.println("这是B款衣服");
    }
}

//定义一个类来创建对象——这个类就叫工厂类
class ClothesFactory{
    public static Clothes getInstance(String type){
        Clothes clothes=null;
        if(type.equals("A")){
            clothes = new A();
        }else {
            clothes=new B();
        }
        return clothes;
    }
}
public class Client {
    public void buyClothes(Clothes clothes){
        clothes.print();
    }
    public static void main(String[] args) {
        Client client=new Client();
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入你想要的衣服：");
        String type=scanner.nextLine();
        Clothes clothes=ClothesFactory.getInstance(type);
        client.buyClothes(clothes);

    }
}
