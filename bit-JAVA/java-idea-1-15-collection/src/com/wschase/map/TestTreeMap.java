package com.wschase.map;

import java.util.Map;
import java.util.TreeMap;

/**Map接口的实现子类——TreeMap
 * TreeMap是一个可以排序的Map子类，它是按照key的内容进行排序的
 * Author:WSChase
 * Created:2019/1/15
 */
public class TestTreeMap {
    public static void main(String[] args) {
        Map<Integer,String> map=new TreeMap<>();
        map.put(2,"C");
        map.put(0,"A");
        map.put(1,"B");
        System.out.println(map);
    }
}
