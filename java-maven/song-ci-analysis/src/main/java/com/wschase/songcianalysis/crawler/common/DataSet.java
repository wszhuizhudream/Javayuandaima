package com.wschase.songcianalysis.crawler.common;



import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**存储清洗的数据
 * Author:WSChase
 * Created:2019/3/28
 */
@Data
public class DataSet {
    /**
     * data把文档（DOM）解析，清洗之后存储的数据
     * 就是我们真正需要的数据（诗的标题、朝代、正文）
     * 比如：<key,value>的格式
     * 标题：送孟浩然之广陵
     * 作者：李白
     * 正文：xxx
     */
    private Map<String,Object> data=new HashMap<>();


    //不会让你随意操作key、value，只能通过下面的方法进行操作
    public void putData(String key,Object value){
        //往集合中添加数据
        this.data.put(key,value);
    }

    public Object getData(String key){
        //通过key获取value的值
        return this.data.get(key);
    }

    public Map<String, Object> getData() {
        return new HashMap<>(this.data);
    }


}
