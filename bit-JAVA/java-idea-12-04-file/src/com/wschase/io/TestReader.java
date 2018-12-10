package com.wschase.io;

import java.io.*;

/**
 * Author:WSChase
 * Created:2018/12/7
 */
//字符输入流（读取文件中的数据）
public class TestReader {
    public static void main(String[] args) throws IOException {
        File file=new File("E:"+ File.separator+"learn"+File.separator+"javaio"+File.separator+"a1");
        if(file.exists()){
            Reader in=new FileReader(file);
            char[] data=new char[1024];//最大可以读取的范围
            int len=in.read(data);//通过read返回的是读取到的长度
            //将数组转化为字符串
            String result=new String(data,0,len);
            System.out.println("读取到的内容为："+result);
            in.close();
        }
    }
}
