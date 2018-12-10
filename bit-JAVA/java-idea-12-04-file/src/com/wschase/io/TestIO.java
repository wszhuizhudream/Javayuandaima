package com.wschase.io;

/**输入输出流
 * Author:WSChase
 * Created:2018/12/4
 */
public class TestIO {
    public static void main(String[] args) {
        //一、input.txt->application->output.txt（文件的输入——>输出）
        //1.输入流：
        //1.1准备文件
        //1.2实例化文件的输入流对象（FileInputStream）
        //1.3read()读取数据
        //1.5关闭输入流->在finally块

        //2.输出流
        //2.1准备文件，输出流没有这个文件程序会自动创建，但是如果没有目录那么就会报错，找不到目录
        //2.2实例化文件的输出流对象（FileOutputStream）
        //2.3准备业务处理数据
        //2.3write() 输出数据
        //2.4 关闭输出流->在finally块

        //3.业务处理
        //3.1读取数据 while(){},读到末尾返回-1


    }
}
