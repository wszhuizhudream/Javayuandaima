package com.wschase.practiceliu;

import java.io.*;

/**自己设计一个打印流
 * Author:WSChase
 * Created:2018/12/8
 */
class PrintUtil{
    private OutputStream out;
    //由外部传入要输出的目标终端
    public PrintUtil(OutputStream out){//构造方法，还是和OutputStream有关
        this.out=out;
    }
    public void print2(String str){//定义一个打印的方法，这个方法可以将传入的参数写进一个文件中
        try{
            this.out.write(str.getBytes());//将任何一种类型转化为字节型作为参数传递
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //不同的打印方法调用打印这个函数，将输入的内容写到文件中
    public void println(String str){
        this.print2(str+"\n");
    }
    public void print2(int data){
        this.print2(String.valueOf(data));//将任何类型转化为字符串类型
    }
    public void println(int data){
        this.println(String.valueOf(data));
    }
    public void print2(double data){
        this.print2(String.valueOf(data));
    }
    public void println(double data){
        this.println(String.valueOf(data));
    }
}
public class TestPrint {
    public static void main(String[] args) throws FileNotFoundException {
        PrintUtil printUtil=new PrintUtil(new FileOutputStream(new File("E:"+File.separator+"learn"+File.separator+"javaio"+File.separator+"data1.txt")));
        printUtil.print2("姓名");
        printUtil.print2(10);
        printUtil.println(15);
        printUtil.print2(10.23);
    }
}
