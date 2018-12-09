package com.wschase.file;

import java.io.*;

/**
 * Author:WSChase
 * Created:2018/12/8
 */
////打印流
// class PrintUtil {
//    private OutputStream out;
//    public PrintUtil(OutputStream out){
//        this.out=out;
//    }
//    //其核心功能就一个
//    public void print(String str){
//        try{
//            this.out.write(str.getBytes());
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }
//    public void println(String str){
//        this.print(str+"\n");
//    }
//    public void print(int data){
//        this.print(String.valueOf(data));
//    }
//    public void println(int data){
//        this.print(String.valueOf(data));
//    }
//    public void print(double data){
//        this.print(String.valueOf(data));
//    }
//    public void println(double data){
//        this.print(String.valueOf(data));
//    }
//}
//public class Print{
//    public static void main(String[] args) throws FileNotFoundException {
//        PrintUtil p1=new PrintUtil(new FileOutputStream(new File("E:"+File.separator+"learn"+File.separator+"javaio"+File.separator+"data1.txt")));
//        p1.print(27);
//        p1.print("年号");
//        p1.print(10.25);
//        p1.println(15);
//    }
//}


////使用打印流输出
//public class Print{
//    public static void main(String[] args) throws FileNotFoundException {
//        PrintWriter print1=new PrintWriter(new FileOutputStream(new File("E:"+File.separator+"learn"+File.separator+"javaio"+File.separator+"data1")));
//        print1.print(12);
//        print1.print('A');
//        print1.print(12.05);
//        print1.close();
//    }
//}

//格式化输出
public class Print{
    public static void main(String[] args) throws FileNotFoundException {
        String name="小明";
        int age=20;
        double salary=1000.23456;
        PrintWriter printUtil=new PrintWriter(new FileOutputStream(new File("E:"+File.separator+"learn"+File.separator+"javaio"+File.separator+"data1.txt")));
        printUtil.printf("姓名：%s,年龄：%d,工资：%1.4f",name,age,salary);
        printUtil.close();
    }
}