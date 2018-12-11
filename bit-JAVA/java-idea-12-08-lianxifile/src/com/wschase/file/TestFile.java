package com.wschase.file;

import java.io.File;
import java.io.IOException;

/**File文件练习
 * Author:WSChase
 * Created:2018/12/9
 */
public class TestFile {
    public static void code1() throws IOException {
        //创建了一个文件对象(只是告诉了它在这个路径下存在这个一个文件)
        File file=new File("E:"+ File.separator+"learn"+File.separator+"javaio"+File.separator+"data1.txt");
        if(file.exists()){//调用这个方法区判断文件是否存在
            file.delete();
        }else{//创建这个文件
            file.createNewFile();
        }
    }
public static void code2(){
    File file=new File("E:"+ File.separator+"learn"+File.separator+"javaio"+File.separator+"data1.txt");
    System.out.println(file.getParent());
    System.out.println("-------------");
    System.out.println(file.getParentFile());
}
    public static void main(String[] args) throws IOException {
        TestFile.code1();
        TestFile.code2();
    }
}
