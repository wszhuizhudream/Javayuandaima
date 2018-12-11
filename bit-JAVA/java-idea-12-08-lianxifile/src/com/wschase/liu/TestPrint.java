package com.wschase.liu;

import java.io.*;

/**
 * Author:WSChase
 * Created:2018/12/9
 */

//class Person1 implements Serializable {
//    private String name;
//    private int age;
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Person [name="+name+",age="+age+"]";
//    }
//}
//public class TestPrint {
//        public static final File file = new File("E:"+File.separator+"learn"+File.separator+"javaio"+File.separator+"data1.txt");
//    public static void main(String[] args) throws IOException {
////实现序列化
//       ser(new Person("jon",20));
//    }
//
//    private static void ser(Person jon) throws IOException {
//        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
//        oos.write(obj);//实现序列化
//        oos.close();
//    }
//    public static void code1(){
        //        //BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
//        //我们需要注意的是System.in是字节输入流InputStream的子类，所以我们要实现从控制台输入然后读取这个过程
//        //需要我们将字节输入流转化为字符输入流来处理；其中这个转换我们需要通过转换流来实现。
//        //上面这条语句相当于是下面的这些语句：
//        InputStream input=System.in;
//        //将字节输入流转变为字符输入流
//        InputStreamReader inputStreamReader=new InputStreamReader(input);
//        BufferedReader buf=new BufferedReader(inputStreamReader);
//        //这样就有了字符缓冲流
//        System.out.println("请输入信息：");
//        String str=buf.readLine();//按回车符换行
//        System.out.println("输入的信息是："+str);

//    }
//}



