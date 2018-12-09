package com.wschase.file;

import java.io.*;
import java.nio.file.Paths;

/**
 * Author:WSChase
 * Created:2018/12/8
 */
//字符流与字节流的相互转化
public class TestOutputStreamWriter {
    public static void main(String[] args) throws Exception {
        //字节流->字符流  编码
        //字符流->字节流  解码

        //1.创建字符流：
        File srcFile = Paths.get("E:", "learn", "javaio", "a1").toFile();//准备文件
        File destFile = Paths.get("E:", "learn", "javaio", "a3").toFile();//读的文件
        try(
                FileInputStream inputStream = new FileInputStream(srcFile);//准备输入流对象
                FileOutputStream outputStream = new FileOutputStream(destFile);//准备输出流对象
                InputStreamReader reader = new InputStreamReader(inputStream);//将字节流对象传到方法中-》转化为字符流
                //下面就可以用reader按照字符流读了
                OutputStreamWriter writer = new OutputStreamWriter(outputStream)//将字节输出流作为参数传递-》最后一个省略分号
        ) {
            //按照字符读取
            char[] buff = new char[1024];//不要开辟太大，这个空间是会在内存开辟的
            int len = -1;
            //在读取内容的时候，将内容放进字符数组中，同时返回读取的个数，当没有数据了但还在读，这个时候就返回-1，所以用-1来判断是否还在读取数据
            while ((len = reader.read(buff)) != -1) {
                writer.write(buff,0,len);
            }
        } catch (Exception e) {

        }
    }
}
