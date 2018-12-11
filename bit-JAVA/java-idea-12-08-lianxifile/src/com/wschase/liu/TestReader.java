package com.wschase.liu;

import java.io.*;

/**字符输入流
 * Author:WSChase
 * Created:2018/12/8
 */
public class TestReader {
    public static void main(String[] args) {
        File file=new File("E:"+ File.separator+"learn"+File.separator+"javaio"+File.separator+"data1.txt");
        if(!file.getParentFile().exists()){//判断如果父路径不存的话就创建这个路径
            file.getParentFile().mkdirs();
        }
        try(Reader reader=new FileReader(file)){
         char[] buff=new char[1024];
         int len=-1;
         while((len=reader.read(buff))!=-1){//这个条件是为了判断知否读完数据
             //System.out.println(String.valueOf(buff));//边读边输出，将字符数组转化为字符串
             System.out.println(buff);
         }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
