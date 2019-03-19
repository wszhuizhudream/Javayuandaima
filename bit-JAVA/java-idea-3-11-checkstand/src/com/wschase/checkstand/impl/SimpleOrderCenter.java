package com.wschase.checkstand.impl;

import com.wschase.checkstand.Goods;
import com.wschase.checkstand.GoodsCenter;
import com.wschase.checkstand.Order;
import com.wschase.checkstand.OrderCenter;

import java.util.HashMap;
import java.util.Map;

/**实现商品信息接口的类
 * Author:WSChase
 * Created:2019/3/11
 */
public class SimpleOrderCenter implements OrderCenter {
    //定义一个集合，用集合来实现商品信息的增删改查，key表示商品的id，values表示商品的订单信息
  private final HashMap<String,Order> orderMap=new HashMap<>();

  private GoodsCenter goodsCenter;

  public SimpleOrderCenter(GoodsCenter goodsCenter){
      this.goodsCenter=goodsCenter;
  }

    @Override
    public void addOrder(Order order) {
        this.orderMap.put(order.getOrderId(),order);

    }

    @Override
    public void removeOrder(Order order) {
        this.orderMap.remove(order.getOrderId(),order);

    }

    @Override
    public String ordersTable() {
      StringBuilder sb=new StringBuilder();
      sb.append("=============================");
      sb.append("\n");
      sb.append("编号  总价");
      sb.append("\n");
      for(Order order:this.orderMap.values()){
          Map<String,Integer> goodsMap=order.getOrderInfo();
          double totalPrice=0.0;
          for(Map.Entry<String,Integer> entry:goodsMap.entrySet()){
              String goodsId=entry.getKey();
              Integer goodsCount=entry.getValue();
              Goods goods=goodsCount.getGoods(goodsId);
              totalPrice+=goods.getPrice()*goodsCount;
          }
          sb.append(String.format("%2s\t\t%.2f",order.getOrderId(),totalPrice));
          sb.append("\n");
      }

      sb.append("==================================");
      sb.append("\n");
        return sb.toString();
    }

    //你给我一个编号，我就将这个编号对应的信息打印出来
    @Override
    public String orderTable(String orderId) {
        StringBuilder sb = new StringBuilder();
        Order order = this.orderMap.get(orderId);
        sb.append("===============================");
        sb.append("\n");
        sb.append("编号: " + order.getOrderId());
        sb.append("\n");
        sb.append("打印时间: " + LocalDate.now().toString());
        sb.append("\n");
        sb.append("===============================");
        sb.append("\n");
        sb.append("编号     名称      数量     单价");
        sb.append("\n");
        double total = 0.0D;
        for (Map.Entry<String, Integer> entry : order.getOrderInfo().entrySet()) {

            Goods goods = this.goodsCenter.getGoods(entry.getKey());
            sb.append(String.format("%2s\t%s\t%d\t%.2f", entry.getKey(), goods.getName(), entry.getValue(), goods.getPrice()));

            total += goods.getPrice() * entry.getValue();

            sb.append("\n");
        }
        sb.append("===============================");
        sb.append("\n");
        sb.append(String.format("总价: %.2f", total));
        sb.append("\n");
        sb.append("===============================");
        sb.append("\n");
        return sb.toString();

    }
    @Override
    public void storeOrders() {

      //存储到文件
      //1=id:totalPrice:goodsId-number:goodsId-number
        System.out.println("保存所有订单到文件每个订单记录：编号和总价");

    }

    @Override
    public void loadOrder(){
        System.out.println("订单加载");
    }
}
