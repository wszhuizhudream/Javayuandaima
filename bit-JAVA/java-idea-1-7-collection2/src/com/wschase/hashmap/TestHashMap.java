package com.wschase.hashmap;

import java.util.Hashtable;
import java.util.Map;

/**这一节讲的是HashMap但是前面的12月11日和12月13日和12.16（前面半节）的三节课还需要再复习
 * Author:WSChase
 * Created:2019/1/7
 */
//Map集合
//1.HashMap
public class TestHashMap {
    public static void main(String[] args) {
        Map<String,String> map=new Hashtable<>();
        map.put("1","java");
        map.put("2","C++");
        //在HashTable中如果key=null，那么将会出现空指针
        map.put(null,"PHP");//error
        //同样的在Hashtable中value同样不能去null
        map.put("3",null);//error
        System.out.println(map);
    }
}
