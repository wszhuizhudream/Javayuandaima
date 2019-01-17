package com.wschase.map;

import java.util.Hashtable;
import java.util.Map;

/**Map接口的实现子类——HashTable:元素的存放是逆序的
 * Author:WSChase
 * Created:2019/1/15
 */
public class HashTable {
    public static void main(String[] args) {
        Map<Integer,String> map1=new Hashtable<>();

        //往集合map1中存放元素
        map1.put(1,"zhifou");
        //key重复
        map1.put(1,"nihao");
        map1.put(3,"bit");
        map1.put(2,"juanlian");
        //value重复
        map1.put(4,"zhifou");
        System.out.println(map1);
    }
}
