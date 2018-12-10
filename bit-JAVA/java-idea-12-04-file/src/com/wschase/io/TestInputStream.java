package com.wschase.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Author:WSChase
 * Created:2018/12/7
 */
////字节输入流：
//public class TestInputStream {
//    public static void main(String[] args) throws IOException {
//        //1.定义文件路径-->采用Path的方法
//        Path path=Paths.get("E:","learn","javaio","a1");
//        File file=path.toFile();//将路径转化为文件
//        //注意：当我们使用Path方法实例化File对象的时候就不需要进行判断文件是否存在了，因为
//        //toFile()就是将路径转化为了文件，所以我们的文件是已经存在了的。
//            InputStream input = new FileInputStream(file);
//            byte[] data=new byte[1024];//每次可以读取的最大数量
//            int len =input.read(data);//此时已经将文件中的数据按照字节读取到了数组中
//            String result=new String(data,0,len);//将字节数组转化为String类型
//        System.out.println("读取到的内容为："+result);
//        input.close();
//    }
//}

