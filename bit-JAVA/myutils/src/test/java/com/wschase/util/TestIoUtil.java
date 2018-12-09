package com.wschase.util;

import com.bittech.util.IoUtil;

import java.io.*;
import java.nio.file.Paths;


/**I/O测试
 * Author:WSChase
 * Created:2018/12/9
 */
public class TestIoUtil {
        //1.将Reader中的内容复制到Writer中 使用默认缓存大小
    public static void code1(){
        //(1)先创建文件(通过toFile()创建的文件就是普通文件)
        File file1= Paths.get("E:","learn","javaio","data1.txt").toFile();
        File file2=Paths.get("E:","learn","javaio","data2.txt").toFile();
        try(
                Reader reader=new FileReader(file1);
                Writer writer=new FileWriter(file2);
                ) {
            long count=IoUtil.copy(reader,writer);
            System.out.println("两个流之间拷贝的字节数是：");
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

        //2.拷贝流，使用默认Buffer大小
    public static void code2(){
        //需要两个参数一个是输入流，一个是输出流
        File file1= Paths.get("E:","learn","javaio","data1.txt").toFile();
        File file2=Paths.get("E:","learn","javaio","data2.txt").toFile();
        try(
                InputStream input=new FileInputStream(file1);
                OutputStream out=new FileOutputStream(file2);
        ){
            long count=IoUtil.copy(input,out);//连个文件之间传输的字节数
            System.out.println("两个流之间传输的字节数是：");
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

        //3.拷贝文件流，使用NIO
    public static void code3() throws IOException {
        File file1= Paths.get("E:","learn","javaio","data1.txt").toFile();
        File file2=Paths.get("E:","learn","javaio","data2.txt").toFile();
        try(
                FileInputStream in=new FileInputStream(file1);
                FileOutputStream out=new FileOutputStream(file2);

        ){
            long count=IoUtil.copy(in,out);
            System.out.println("拷贝的字节数是：");
            System.out.println(count);
        }catch (IOException e){
            e.getMessage();
        }
    }

        //4.从Reader中读取String，读取完毕后并不关闭Reader
    public static void code4() throws IOException {
        File file1= Paths.get("E:","learn","javaio","data1.txt").toFile();
        //字节输入流
        Reader reader=new FileReader(file1);
        String content=IoUtil.read(reader);
        System.out.println("读到的内容是：");
        System.out.println(content);
    }

        //5.对比两个流内容是否相同
    public static void code5() throws FileNotFoundException {
        File file1= Paths.get("E:","learn","javaio","data1.txt").toFile();
        File file2=Paths.get("E:","learn","javaio","data2.txt").toFile();
        try(
        InputStream input1=new FileInputStream(file1);
        InputStream input2=new FileInputStream(file2);
                ) {
           boolean result = IoUtil.contentEquals(input1,input2);
            System.out.println("两个流中内容相比的结果是：");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TestIoUtil.code1();
        TestIoUtil.code2();
        TestIoUtil.code3();
        TestIoUtil.code4();
        TestIoUtil.code5();
    }
}
