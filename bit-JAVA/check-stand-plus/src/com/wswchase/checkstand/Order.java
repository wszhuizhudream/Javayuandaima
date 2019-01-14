package com.wswchase.checkstand;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**订单
 * Author:WSChase
 * Created:2019/1/9
 */
public class Order {

    private final String orderId;

    private final Map<String,Integer> goodsInfo = new HashMap<>();

    public Order(String orderId){
        this.orderId=orderId;
    }

    /**
     * 订单添加商品
     * @param goodsId 商品编号
     * @param count   数量
     */
    public void add(String goodsId,Integer count){
//        Optional<Integer> current=Optional.ofNullable(this.goodsInfo.get(goodsId));
//        Integer sum=current.map(integer -> integer+count).orElse(count);
//        this.goodsInfo.put(goodsId,sum);

        //换一种写法
        Integer sum=this.goodsInfo.get(goodsId);
        if(sum==null){//则表明我们是第一次添加
            sum=count;
        }else {
            sum+=count;
        }
        this.goodsInfo.put(goodsId,sum);
    }

    //取消
    public void cancel(String goodsId,Integer count){
//        Optional<Integer> current=Optional.ofNullable(this.goodsInfo.get(goodsId));
//        Integer sum=current.map(integer -> integer-count).orElse(0);
//        this.goodsInfo.put(goodsId,sum<=0?0:sum);

        //换一种写法
        Integer sum=this.goodsInfo.get(goodsId);
        if(sum!=null){
            sum-=count;
            sum=sum<0?0:sum;
            if(sum>0){
            this.goodsInfo.put(goodsId,sum);
            }else {
                this.goodsInfo.remove(goodsId);
            }
        }
    }


    //清除
    public void clear(){
        this.goodsInfo.clear();//Map只要一clear()就什么都没有了
    }

    public String getOrderId(){
        return orderId;
    }

    public String orderTable(){
        //TODO打印信息
        return "";
    }
}
