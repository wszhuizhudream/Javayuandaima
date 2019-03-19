package com.wschase.checkstand;

/**商品中心
 * Author:WSChase
 * Created:2019/3/11
 */
public interface GoodsCenter {
    //添加商品
     void addGoods(Goods goods);

    //移除商品
    void deleteGoods(String goodsId);

    //更新商品
    void updateGoods(Goods goods);

    //判断商品是否存在
    boolean iSExistGoods(String goodsId);

    //通过商品编号获取商品
    Goods getGoods(String goodsId);

    //列出商品信息
    String listGoods();

    //保存商品信息
    void store();

    //加载商品信息
    void load();


}
