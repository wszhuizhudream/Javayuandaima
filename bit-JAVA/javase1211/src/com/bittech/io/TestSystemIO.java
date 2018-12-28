package com.bittech.io;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Author: secondriver
 * Created: 2018/12/9
 */
public class TestSystemIO {
    
    public static void code1() {
        try {
            Integer value = Integer.parseInt("abc");
            System.out.println(value);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.err.println(e.getMessage());
        }
    }
    
    public static void code2() {
        //OutputStream的输出位置变成屏幕(控制台)
        OutputStream out = System.out;
        try {
            out.write("Hello".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void code3() {
        InputStream in = System.in;
        byte[] buff = new byte[5];
        System.out.println("请输入内容：");
        try {
            int len = in.read(buff);
            System.out.println(new String(buff, 0, len));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void code4() {
        InputStream in = System.in;
        byte[] buff = new byte[5];
        System.out.println("请输入内容：");
        int len = -1;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
                if (len < buff.length) {
                    break;
                }
            }
            System.out.println(new String(out.toByteArray()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public static void code5() {
        //BufferedReader  -> InputStreamReader  ->  InputStream
        try (InputStream inputStream = System.in;
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(inputStreamReader);) {
            String line;
            System.out.println("请输入内容：");
            while (!(line = reader.readLine()).equals("q")) {
                System.out.println(line);
            }
            System.out.println(line);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public static void code6(){
        //需求：借助BufferedReader实现点名程序
        //思路：
        // 1. 人员数据
        // 2. 人员读入到程序
        // 3. 生成随机数和人员关联
        // 4.输出目标人员
        //技术点：
        // 1. 爬虫
        // 2. I/O 字符流
        // 3. Random Array
        // 4. Out
    
        File studentDataFile = Paths.get("D:", "test", "java6_student.txt").toFile();
    
        try (InputStream in = new FileInputStream(studentDataFile);
             Reader inputStreamReader = new InputStreamReader(in);
             BufferedReader reader = new BufferedReader(inputStreamReader)
        ) {
            String line = null;
            String[] student = new String[42];
            int index = -1;
            while ((line = reader.readLine()) != null) {
                index++;
                student[index] = line;
            }
            Random random = new Random();
            int selectIndex = random.nextInt(student.length);
            System.out.println("选择的学生是：" + student[selectIndex]);
        
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public static void main(String[] args) {
    
    
    
    }
}
