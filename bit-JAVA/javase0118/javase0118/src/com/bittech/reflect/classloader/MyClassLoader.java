package com.bittech.reflect.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Author: secondriver
 * Created: 2019/1/18
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class MyClassLoader extends ClassLoader {
    
    
    public Class<?> loadData(String name) throws ClassNotFoundException {
        try {
            byte[] classData = loadClassByte(name);
            return this.defineClass(name, classData, 0, classData.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
    
    
    //name类 -> .class
    //.class文件通过文件读取的方式变成byte[]
    private byte[] loadClassByte(String name) {
        //classpath + classname
        File file = new File("E:\\Member.class");
        try (FileInputStream inputStream = new FileInputStream(file);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
        ) {
            byte[] buff = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, len);
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
