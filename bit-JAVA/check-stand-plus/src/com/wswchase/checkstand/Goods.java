package com.wswchase.checkstand;

/**商品信息
 * Author:WSChase
 * Created:2019/1/9
 */
public class Goods {
    //商品编号
    private String id;

    //商品名称
    private String name;

    //商品价格
    private double price;

    public Goods(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("[%2s] %s %.2f",this.getId(),this.getName(),this.getPrice());

    }
}
