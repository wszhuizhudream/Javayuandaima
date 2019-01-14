package com.wswchase.checkstand.impl;

import com.wswchase.checkstand.Goods;
import com.wswchase.checkstand.GoodsCenter;

import java.util.HashMap;
import java.util.Map;

/**实现商品信息接口的类
 * Author:WSChase
 * Created:2019/1/9
 */
public class SimpleGoodsCenter implements GoodsCenter {
    //此时我们不用数组了。用集合来实现商品的信息的增删改查，用key表示商品的id、values表示商品的信息。
    private final Map<String,Goods> goodsMap=new HashMap<>();
    @Override
    public void addGoods(Goods goods) {
        this.goodsMap.put(goods.getId(),goods);//将元素放进集合里面
    }

    @Override
    public void removeGoods(String goodsId) {
        this.goodsMap.remove(goodsId,goodsId);
    }

    @Override
    public void updateGoods(Goods goods) {
        if(this.goodsMap.containsKey(goods.getId())){
            this.goodsMap.put(goods.getId(),goods);
        }
    }

    @Override
    public boolean isExistGoods(String goodsId) {
        return this.goodsMap.containsKey(goodsId);
    }

    @Override
    public String listGoods() {
        //TODO（打印商品信息）
        return null;
    }

    @Override
    public void store() {
        //TODO（将GoodsMap里面的数据存储单文件里面）
    }
}
