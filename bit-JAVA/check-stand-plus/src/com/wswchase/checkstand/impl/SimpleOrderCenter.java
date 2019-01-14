package com.wswchase.checkstand.impl;

import com.wswchase.checkstand.Order;
import com.wswchase.checkstand.OrderCenter;

import java.util.HashMap;
import java.util.Map;

/**商品订单的实现类
 * Author:WSChase
 * Created:2019/1/9
 */
public class SimpleOrderCenter implements OrderCenter {
    private Map<String,Order> orderMap=new HashMap<>();

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
        //TODO（打印信息）
        return null;
    }

    @Override
    public void storeOrders() {
        //TODO  （将orderMap里面的信息存储到文件里面）
    }
}
