package com.bittech.io;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Author: secondriver
 * Created: 2018/12/9
 */
public class TestScanner {
    
    public static void code1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容：");
        if (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        scanner.close();
    }
    
    public static void code2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年龄：");

//        if (scanner.hasNextInt()) {
//            System.out.println(scanner.nextInt());
//        } else {
//            System.out.println("输入的不是数字");
//        }
        
        while (true) {
            if (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
                break;
            } else {
                System.out.println("输入的不是数字,重新输入");
                scanner.next();//丢弃掉不符合要求的数据
            }
        }
        scanner.close();
    }
    
    public static void code3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入生日：");
        while (true) {
            // 2018-05-07
            if (scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")) {
                System.out.println(scanner.next());
                break;
            } else {
                System.out.println("输入的日期格式不正确,重新输入");
                scanner.next();//丢弃掉不符合要求的数据
            }
        }
        scanner.close();
    }
    
    public static void code4() {
        //Scanner构造方法中传入文件，替代BufferedReader，读取文件
        try (Scanner scanner = new Scanner(Paths.get("D:", "test", "java6_student.txt"));) {
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
    
    }
}
