package com.wschase.checkstand.impl;

import com.wschase.checkstand.Goods;
import com.wschase.checkstand.GoodsCenter;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:WSChase
 * Created:2019/3/11
 */
public class SimpleGoodsCenter implements GoodsCenter {

    //定义一个集合，这个集合用来存放商品，根据编号存放不同的商品
    private final Map<String,Goods> goodsMap=new HashMap<>();

   //当前存在文件中
    private String filePath=System.getProperty("user.dir")+ File.separator+"goods.txt";

    @Override
    public void addGoods(Goods goods) {
        //我们只需要添加进去进行了，不管它里面是否有这个商品
        this.goodsMap.put(goods.getId(),goods);
    }

    @Override
    public void deleteGoods(String goodsId) {
        this.goodsMap.remove(goodsId);

    }

    @Override
    public void updateGoods(Goods goods) {
        //通过编号判断，如果这个商品存在就将商品更新
        if(this.goodsMap.containsKey(goods.getId())){
            this.goodsMap.put(goods.getId(),goods);
        }
    }

    @Override
    public boolean iSExistGoods(String goodsId) {

        return this.goodsMap.containsKey(goodsId);
    }

    @Override
    public Goods getGoods(String goodsId) {
        return this.goodsMap.get(goodsId);
    }

    @Override
    public String listGoods() {


        StringBuilder sb=new StringBuilder();
        sb.append("***************商品信息***************\n");
        sb.append("\t\t编号\t商品名称\t单价\n");
        for(Map.Entry<String,Goods> entry:this.goodsMap.entrySet()){
            Goods goods=entry.getValue();
            sb.append(String.format("\t\t%s\t%s\t%.2f\n,",goods.getId(),goods.getName(),goods.getPrice()));
        }
        sb.append("*************************************\n");
        return sb.toString();
    }

    @Override
    public void store() {

        //编号：名称：单价
        //1:小米：22
        //File I/O
        File file=new File(filePath);
        try(BufferedWriter writer=new BufferedWriter(
            new FileWriter(file)
        )){
            //往文件中写东西
            for(Map.Entry<String,Goods> entry:this.goodsMap.entrySet()){
                Goods goods=entry.getValue();
                writer.write(String.format("%s:%s:%.2f\n",goods.getId(),goods.getName(),goods.getPrice()));

        }

    } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        //加载就是将信息从文件中读来存到集合中
        File file1=new File(filePath);
        if(file1.exists()&&file1.isFile()){
            try(BufferedReader reader=new BufferedReader(
                    new FileReader(file1)
            )){

                //读的时候按照行读
                String line;
                while ((line=reader.readLine())!=null){
                    String[] values=line.split(":");//使用"："分割
                    if(values.length==3){

                        Goods goods=new Goods(
                                values[0],
                                values[1],
                                Double.parseDouble(values[2])
                        );
                        this.addGoods(goods);
                    }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
