package com.wschase.dianming;

import java.io.*;
import java.nio.file.Paths;
import java.util.Random;

/**通过输入输出流实现随机点名
 * 思路：借助BufferedReader
 * (1)人员数据
 * (2)将人员读到程序
 * (3)生成随机数与人员关联
 * (4)输出目标人员
 * Author:WSChase
 * Created:2018/12/10
 */
public class OrderName {
    public static void main(String[] args) throws IOException {

    //实现技术：
    //（1）爬虫：目前我们使用最简单的方法-》通过复制粘贴从网页上获得人员数据
    //（2）通过字符流：从FileInputStream——>到BufferedReader
    //（3）Random/Array将读出来的数据存放到一个数组中然后将这个数组的索引与随机数对应起来，这样的话人员和随机数就对应起来了
    //（4）System.out.println

//    (1)人员数据
//    (2)将人员读到程序
        File file= Paths.get("E:","learn","javaio","data1.txt").toFile();
        try(
                InputStream in=new FileInputStream(file);
                //将字节输入流转化为字符输入流
                InputStreamReader inputStreamReader=new InputStreamReader(in);
                BufferedReader buf=new BufferedReader(inputStreamReader);
        ){
        String[] student_name=new String[14];
        String line=null;
        int index=-1;
        while((line=buf.readLine())!=null){//如果不为null则表示还没有读完
            //将读取的结果存放到一个字符数组中
            index++;
            student_name[index]=line;//用readLine读返回的内容就是读取的一行的内容
        }
//    (3)生成随机数与人员关联
        //下面是产生随机数的方法
        Random random=new Random();
        int num=random.nextInt(14);//返回的是从[0,13]区间的任意一个随机数
//    (4)输出目标人员
        System.out.println(student_name[num]);

        }catch (IOException e){
            e.getMessage();
        }
    }


}
