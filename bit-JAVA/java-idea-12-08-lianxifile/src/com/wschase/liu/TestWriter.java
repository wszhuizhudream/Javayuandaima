package com.wschase.liu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Paths;

/**这个是我们字符的输出流
 * 就是往我们的文件中写数据
 * Author:WSChase
 * Created:2018/12/8
 */
public class TestWriter {
    public static void main(String[] args) {
        File file=Paths.get("E:","learn","javaio","data1.txt").toFile();//创建一个文件
        try(Writer writer=new FileWriter(file)) {//创建字节输出流的对象，通过这个对象才可以去调用写入的方法
        writer.write("如果不是你");//在字符输出流中可以直接输入字符串
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
