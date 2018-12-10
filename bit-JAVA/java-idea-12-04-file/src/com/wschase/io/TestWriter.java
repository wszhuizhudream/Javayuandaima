package com.wschase.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Author:WSChase
 * Created:2018/12/7
 */
//public class TestWriter {
//    //字符输出流（注意我们的磁盘数据保存的单位都是字节，所以我们的字符需要处理）
//    public static void main(String[] args) throws IOException {
//        Path path= Paths.get("E:","learn","javaio","a1");
//        File file=path.toFile();
//        String msg="裂缝中的阳光";
//        //Writer是字符输出流的类，它也是抽象类，实例化它的对象需要通过它的子类FileWriter
//        Writer out=new FileWriter(file);//在字符输出流中没有追加的这个方法
//        //由于在字符输出流类的方法中的这个write()方法的参数可以是字符串型的，所以我们可以直接将字符串传入，
//        // 然后将内容写到文件中。
//        out.write(msg);
//        out.close();
//    }
//}


//字符流刷新操作
public class TestWriter {
    //字符输出流（注意我们的磁盘数据保存的单位都是字节，所以我们的字符需要处理）
    public static void main(String[] args) throws IOException {
        Path path= Paths.get("E:","learn","javaio","a1");
        File file=path.toFile();
        String msg="裂缝中的阳光2222";
        //Writer是字符输出流的类，它也是抽象类，实例化它的对象需要通过它的子类FileWriter
        Writer out=new FileWriter(file);//在字符输出流中没有追加的这个方法
        //由于在字符输出流类的方法中的这个write()方法的参数可以是字符串型的，所以我们可以直接将字符串传入，
        // 然后将内容写到文件中。
        out.write(msg);
        out.flush();
    }
}
