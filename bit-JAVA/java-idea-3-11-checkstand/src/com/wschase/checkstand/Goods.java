package com.wschase.checkstand;

/**商品信息
 * Author:WSChase
 * Created:2019/3/11
 */
public class Goods {
    //商品名称
    String name;


    //商品编号
    String id;

    //商品价格
    double price;

  //构造方法

    public Goods(String name,String id , double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        //%.2f表示保留两位小数
        return String.format("[%2s] %s %.2f",this.getId(),this.getName(),this.getPrice());
    }
}
