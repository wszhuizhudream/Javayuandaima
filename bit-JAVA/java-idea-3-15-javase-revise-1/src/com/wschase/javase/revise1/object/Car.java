package com.wschase.javase.revise1.object;

import javax.smartcardio.CardChannel;

/**对象的实例化
 * Author:WSChase
 * Created:2019/3/15
 */
public class Car {
    private String color;
    private int id;
    private int price;

    public Car(String color, int id, int price) {
        this.color = color;
        this.id = id;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    void khapTronPai(){
        System.out.println("向前开");
    }

    String carInfo(){
        return "这个车的颜色是："+color+"车牌号为："+id+"价格是"+price;
    }

    public static void main(String[] args) {
        Car car=new Car("黄色",1002356,100000);
        System.out.println(car.carInfo());
        //私有的属性可以直接通过对象名来访问;在本类里面也可以通过对象名来修改
        car.price=154;
        System.out.println(car.carInfo());
        System.out.println(car.color);
        car.khapTronPai();
    }
}
