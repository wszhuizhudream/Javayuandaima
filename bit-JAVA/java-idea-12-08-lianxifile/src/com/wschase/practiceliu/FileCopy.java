package com.wschase.practiceliu;

import java.io.*;
import java.nio.file.Paths;

/**文件拷贝
 * 当我们在通过I/O流进行文件拷贝的时候一定要将校验做到最精确，将所有可能出现的问题都考虑进去(我们采用的是边读边写的方法)
 * 这个方法是只有一个copy函数，这个函数的参数是两个分别是原文件和目标文件的路径（但是这个路径是字符串形式的），通过传入的路径进行检验
 * （1）路径不为空或者是否存在
 * （2）用当前给定的路径创建文件以后：看原文件是否存在并且这个文件是否是普通文件
 * （3）目标文件的父路径是否存在（只有父路径存在才可以创建目标文件）
 * （4）开始复制（边读边写），在异常里面
 * Author:WSChase
 * Created:2018/12/8
 */
public class FileCopy {
    //在进行拷贝之前我们需要进行三个校验
    //1.判断原文件是否存在：即判断路径是否存在并且这个路径是否为空(参数校验)
    public static void copy(String srcFilePath,String destFilePath){
        if(srcFilePath==null||srcFilePath.isEmpty()){
            throw new IllegalArgumentException("srcFilePath must not null");
        }
        if(destFilePath==null&&destFilePath.isEmpty()){
            throw new IllegalArgumentException("destFilePath must not null");
        }

    //2.原文件不存在或者为目录
    File srcFile=Paths.get(srcFilePath).toFile();
    File destFile=Paths.get(destFilePath).toFile();
    if(!srcFile.exists()||!srcFile.isFile()){
        throw new IllegalArgumentException("srcFile not exists or not file");
    }
    //3.判断目标文件是否存在，如果不存在就创建
    File parentFile=destFile.getParentFile();
    if(!parentFile.exists()){
        if(!parentFile.mkdirs()){
            throw new RuntimeException("can't create"+parentFile.getAbsolutePath()+"dicretion");
        }
    }
    //4.开始复制
        try(
                FileInputStream in=new FileInputStream(srcFile);
                FileOutputStream out=new FileOutputStream(destFile);
                ){
        byte[] buff=new byte[1024];
        int len=-1;
        while((len=in.read(buff))!=-1){//读
            out.write(buff,0,len);//写
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //下面先定义好参数然后传参调用函数
        String src="E:\\learn\\javaio\\data1.txt";
        String dest="E:\\learn\\javaio\\data3.txt";
        //我们看一下拷贝文件需要多长的时间：分别获得拷贝前和拷贝后的当前时间戳相减
        long start=System.currentTimeMillis();
        copy(src,dest);
        long end=System.currentTimeMillis();
        System.out.println((end-start)/1000+" s");
    }
}
