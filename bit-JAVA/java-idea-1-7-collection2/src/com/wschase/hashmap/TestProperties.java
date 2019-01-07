package com.wschase.hashmap;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**文件:当我们想要获取一些文件信息的时候我们就使用Properties这个类去直接读取就可以了，这样比较方便，不需要我们只用数据流
 * Author:WSChase
 * Created:2019/1/7
 */
public class TestProperties {
    public static void main(String[] args) throws IOException {
        //*.properties 称之为属性文件
        //Properties   称之为属性类
        //*.properties->Properties
        //读取文件：lode->Properties  InputStream/Reader
        //写入文件：store->*.properties OutputStream/Writer
        try{

            //1.通过文件FileInputStream
        Properties properties=new Properties();
        properties.load(new FileInputStream("E:\\javasecode\\Javayuandaima\\bit-JAVA\\java-idea-1-7-collection2\\src\\com\\wschase\\hashmap\\hello.properties"));
            //读的方法：
            //1.getProperties(key)
            //2.getProperty(key,defaultValue)
            System.out.println(properties.get("C++"));
            System.out.println(properties.getProperty("C++"));//获得属性
            System.out.println(properties.get("php"));
            System.out.println(properties.get("C++"));
            System.out.println(properties.getProperty("php","php is best"));
            //写的方法：
            //1.put
            //2.setProperty(建议使用这个)
            properties.put("php","php is good");
            properties.setProperty("Go","go is best");

            //存储
            properties.store(new FileOutputStream("E:\\javasecode\\Javayuandaima\\bit-JAVA\\java-idea-1-7-collection2\\src\\com\\wschase\\hashmap\\hello1.properties"));



        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
