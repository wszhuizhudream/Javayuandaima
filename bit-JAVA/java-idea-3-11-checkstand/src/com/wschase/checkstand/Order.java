package com.wschase.checkstand;


import java.util.HashMap;
import java.util.Map;

/**订单
 * Author:WSChase
 * Created:2019/3/11
 */
public class Order {
    //订单编号（订单一旦创建编号就不能变了）
    private final String orderId;

    //订单Order对象创建完成之后，goodsInfo属性实例化HashMap
    private final Map<String, Integer> goodsInfo = new HashMap<>();

    public Order(String orderId) {
        this.orderId = orderId;
    }

    //添加订单
    public void add(String goodsId, Integer count) {
        int sum;
        //在商品信息在是否包含这个商品
        if (goodsInfo.containsKey(goodsId)) {
            //如果订单中的商品信息包含指定的商品编号
            sum = goodsInfo.get(goodsId) + count;
        } else {
            sum = count;
        }
        this.goodsInfo.put(goodsId, sum);
    }

    //删除订单
    public void cancel(String goodsId, Integer count) {
        if (this.goodsInfo.containsKey(goodsId)) {
            int sum = this.goodsInfo.get(goodsId);
            sum = sum - count;
            sum = sum < 0 ? 0 : sum;
            if (sum == 0) {
                this.goodsInfo.remove(goodsId);
            } else {
                //更新这个商品数量
                this.goodsInfo.put(goodsId, sum);
            }
        }
    }

    //修改订单
//    public void modify(String goodsId,Integer count){
//
//    }

    //清空订单
    public void clear() {
        //通过集合里面的方法将商品信息直接清空
        this.goodsInfo.clear();

    }
//自己扩展：

    //列举订单

    //保存订单

    //加载订单


    public String getOrderId() {
        return orderId;
    }

    public Map<String, Integer> getOrderInfo() {
        return this.goodsInfo;
    }
}
