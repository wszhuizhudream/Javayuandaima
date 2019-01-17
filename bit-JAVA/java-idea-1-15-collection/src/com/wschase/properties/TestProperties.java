package com.wschase.properties;

import java.util.Properties;

/**属性文件：*.properties文件
 * 1.Properties原理
 * （1）Properties是Hashtable的子类
 * （2）在这种文件里面存放内容的形式为：key=value
 * 2.Properties属性操作：
 * （1）设置属性：public synchronized Object setProperty(String key,String value)
 * （2）取得属性：public String getProperty(String key)——如果没有指定的key则返回null
 * （3）取得属性：public String getProperty(String key,String defaultValue)——如果没有指定的key则返回默认值
 * Author:WSChase
 * Created:2019/1/15
 */
public class TestProperties {
    public static void main(String[] args) {
        Properties properties=new Properties();

        //设置属性
        properties.setProperty("xa","XiAn");
        properties.setProperty("sh","ShangHai");

        //通过key取得属性
        System.out.println(properties.get("xa"));
        System.out.println(properties.get("bj"));
    }
}
