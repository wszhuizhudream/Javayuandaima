package com.wschase.checkstand;

/**
 * Author:WSChase
 * Created:2019/3/11
 */
public interface OrderCenter {
    //添加订单
    void addOrder(Order order);

    //移除订单
    void removeOrder(Order order);

    //所有订单信息
    String ordersTable();

    //存储订单
    void storeOrders();

    //订单加载
    void loadOrder();

    String orderTable(String orderId);
}
