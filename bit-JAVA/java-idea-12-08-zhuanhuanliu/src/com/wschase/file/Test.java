package com.wschase.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;

/**
 * Author:WSChase
 * Created:2018/12/8
 */
//乱码分析
public class Test {
    public static void main(String[] args) throws UnsupportedOperationException,IOException {
        OutputStream out=new FileOutputStream(Paths.get("E:","learn","javaio","a1").toFile());
        out.write("你好".getBytes("ISO8859-1"));
        out.close();
    }
}
