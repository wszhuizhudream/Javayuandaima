package com.wschase.liu;

import java.io.*;

/**我们通过I/O进行边读边写
 * Author:WSChase
 * Created:2018/12/8
 */
public class Test {
    public static void main(String[] args) {
        //1.首先实例化我们需要读取数据文件、写入数据文件路径的文件类的对象
        File srcFile=new File("E:"+ File.separator+"learn"+File.separator+"javaio"+File.separator+"data1.txt");
        //File destFile=new File("E:"+ File.separator+"learn"+File.separator+"javaio"+File.separator+"data2.txt");
        //2.判断这两个文件的父路径是否存在，如果不存在则创建
        if(srcFile.getParentFile().exists()){
            srcFile.getParentFile().mkdirs();
        }
//        if(destFile.getParentFile().exists()){
//            destFile.getParentFile().mkdirs();
//        }
        try(
                OutputStream out=new FileOutputStream(srcFile,true);//在后面加上这个参数以后文件内容就是追加，在原来的内容上加上新内容
                InputStream in= new FileInputStream(srcFile)
        ) {
            //我们可以有两种方法进行读数据：
            //（1）我们的目标文件中已经有内容了，那么我们可以直接读
            String msg="感动被生活淹没";
            out.write(msg.getBytes());
            byte[] buff=new byte[1024];
            int len=-1;
            while((len=in.read(buff))!=-1){
                System.out.println(new String(buff));//将字节数组转化为字符串
            }
            //（2）目标文件中没有内容，需要我们先写进去然后再读取
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
