package com.wschase.file;

import java.io.*;

/**
 * Author:WSChase
 * Created:2018/12/8
 */
//通过内存流实现大小写的转换
public class TestMerry {
    public static void main(String[] args) throws IOException {
        String msg="hello world";
        //通过内存实现小写转大写
        InputStream input=new ByteArrayInputStream(msg.getBytes());//这一步的操作将msg的数据存到了内存中
        OutputStream output=new ByteArrayOutputStream();//将内存中的数据写道文件中
        int len=-1;
        while((len=input.read())!=-1){//这个read()方法表示一次只读一个字节
            //如果可以进入到这个说明还没有读完数据
            //将读到的数据进行处理放到OutputStream类中
            //边读编写，将读出来的字节经过转换以后写到文件中
            output.write(Character.toUpperCase(len));
        }
        System.out.println(output);
        input.close();
        output.close();
    }
}
