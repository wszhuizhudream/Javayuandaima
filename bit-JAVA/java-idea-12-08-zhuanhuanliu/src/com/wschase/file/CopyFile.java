package com.wschase.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Author:WSChase
 * Created:2018/12/8
 */
////文件拷贝方法1：
//public class CopyFile {
//    public static void main(String[] args) {
//        //   原文件--》目标文件
//        try{
//        String src = args[0];
//        String dest = args[1];
//        cp(src,dest);
//        }catch(ArrayIndexOutOfBoundsException e){
//            System.out.println("参数不符合要求：srcFilePath destFilePath");
//        }
//    }
//
//    //拷贝文件的整个方法
//    public static void cp(String srcFilePath, String destFilePath) {//参数是：原文件，目标文件
//        checkArguments(srcFilePath);
//        checkArguments(destFilePath);
//        checkFileExists(srcFilePath);//原文件要存在
//        checkFileNotExists(destFilePath);//目标文件要不存在
//        File srcFile=Paths.get(srcFilePath).toFile();
//        File destFile=Paths.get(destFilePath).toFile();
//        //拷贝
//        copy(srcFile,destFile);
//
//    }
//
//    //拷贝的方法
//    public static void copy(File srcFile,File destFile){
//        try(FileInputStream in=new FileInputStream(srcFile);
//            FileOutputStream out=new FileOutputStream(destFile)
//        ){
//            //增强版 带缓冲区
//            byte[] buff=new byte[1024];
//            int len;
//            while((len=in.read(buff))!=-1){
//                out.write(buff,0,len);
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//
//    //1.检查参数
//    private static void checkArguments(String args) {
//        if (args == null || args.isEmpty()) {
//            throw new IllegalArgumentException("参数不能为空");
//        }
//    }
//
//    //2.检查文件是否存在并且这个文件是普通文件
//    private static void checkFileExists(String filePath) {
//        Path path = new Paths.get(filePath);
//        File file = path.toFile();
//        if (!(file.exists() && file.isFile())) {
//            throw IllegalArgumentException(filePath + "not exsits");
//        }
//    }
//
//    //3.只是检查这个文件是否存在
//    private static void checkFileNotExists(String filePath) {
//        Path path = new Paths.get(filePath);
//        File file = path.toFile();
//        if ((file.exists())) {
//            throw IllegalArgumentException(filePath + "exsits");
//        }
//    }
//}


//文件拷贝方法2：
public class CopyFile{
    //文件复制
    public static void copy(String srcFilePath,String destFilePath){
        //1.判断路径是否为空(参数检验)
        if(srcFilePath==null||srcFilePath.isEmpty()){
            throw new IllegalArgumentException("srcFilePath must not null");
        }
        if(destFilePath == null||destFilePath.isEmpty()){
            throw  new IllegalArgumentException("destFilePath must not null");
        }
        //文件校验以及准备工作
        File srcFile=Paths.get(srcFilePath).toFile();
        File destFile=Paths.get(destFilePath).toFile();
        //2.原文件不存在或者为目录
        if(!srcFile.exists()||!srcFile.isFile()){
            throw new IllegalArgumentException("srcFilePath file not exists or not file");
        }
        //3.判断目标文件的目录是否存在。如果不存在并且不能创建那文件不可以拷贝
        //我们的输出流只能够创建文件但是不能创建目录，所以前提的保证这个目录是存在的
        File parentFile=destFile.getParentFile();
        if(!parentFile.exists()){
            if(!parentFile.mkdirs()){
                throw new RuntimeException("can't create"+parentFile.getAbsolutePath()+"directory");
            }
        }
        //开始复制
        try(
                FileInputStream in=new FileInputStream(srcFile);
                FileOutputStream out=new FileOutputStream(destFile)
                ){
            //以后在读数据的时候我们都使用缓冲的方法
            //此外注意：缓冲区不要取太大，一般在1k的整数倍就可以了
            byte[] buff=new byte[1024];
            int len=-1;
            while((len=in.read(buff))!=-1){//->读
                out.write(buff,0,len);//->写
            }
        }catch (IOException e){
            e.getMessage();
        }
    }

    public static void main(String[] args) {
        String src="E:\\learn\\javaio\\a1";
        String dest="E:\\learn\\javaio\\tashuo\\t1.exe";
        //获取当前时间戳
        long start = System.currentTimeMillis();
        copy(src,dest);
        long end=System.currentTimeMillis();
        System.out.println((end-start)/1000+" s");
    }
}