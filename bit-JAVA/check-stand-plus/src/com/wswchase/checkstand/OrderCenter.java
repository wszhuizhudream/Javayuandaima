package com.wswchase.checkstand;

/**订单管理
 * Author:WSChase
 * Created:2019/1/9
 */
public interface OrderCenter {
    /**
     * 添加订单
     *
     * @param order
     */
    void addOrder(Order order);

    /**
     * 移除订单
     *
     * @param order
     */
    void removeOrder(Order order);

    /**
     * 所有订单信息
     *
     * @return
     */
    String ordersTable();

    /**
     * 存储订单
     */
    void storeOrders();
}
