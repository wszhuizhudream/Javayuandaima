package com.wschase.file;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * Author:WSChase
 * Created:2018/12/4
 */
public class TestFile {
    //一
    //1.传入一个文件 File
    //2.打印输出如下内容
    //3.每一个文件一行
    //4.E/D name size Last-modified(名字 大小 时间 最后一次修改时间)
    public static void print(File file){
        if(file.exists()&&file.isDirectory()){
//            System.out.println("E:"+file.getName()+"    "+file.length()+"    "+new Date(file.lastModified()));
            File[] result=file.listFiles();
            for(File file1:result){
                            System.out.println("E:"+file1.getName()+"    "+file1.length()+"    "+new Date(file1.lastModified()));
            }
        }
    }
    //二
    //1.递归遍历文件
    //2.输出格式：tree 目录
    public static void tree(File file){
        if (file == null) {
            return;
        }else if(file.isDirectory()){//当前给定的目录为对象
            File[] result=file.listFiles();//继续列出字目录内容
            if(result!=null){
                for(File file2:result){
                    tree(file2);
                }
            }else{
                //如果给定的file是文件就直接打印
                System.out.println(file);
            }

        }
    }


    public static void main(String[] args) {
        TestFile ts=new TestFile();
        File file1=new File("E:"+File.separator+"javasecode"+File.separator+"javayuandaima"+File.separator+"bit-JAVA");
        ts.print(file1);
        File file2=new File("E:"+File.separator+"javasecode");//将已经有的文件抽象为对象
        ts.tree(file2);
        Path path= Paths.get("E:","MySQL");
        File file3=path.toFile();
        ts.print(file3);
    }
}
