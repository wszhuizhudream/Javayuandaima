package com.wschase.reflect2;

import java.io.*;

/**自定义一个类加载器
 * Author:WSChase
 * Created:2019/1/20
 */
public class MyClassLoader extends ClassLoader{
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        byte[] classData=loaderClassByte(name);
        if(classData==null){
            throw new RuntimeException("Not found"+name);
        }
        return super.defineClass(name,classData,0,classData.length);
    }


    //name 类 ->.class
    //.class文件通过文件读取的方式变成byte[]
    private byte[] loaderClassByte(String name) {
        File file=new File(name);
        try(FileInputStream inputStream=new FileInputStream(file);
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream()
        ){
            byte[] buff=new byte[1024];
            int len=-1;
            while ((len=inputStream.read(buff))!=-1){
                outputStream.write(buff,0,len);
            }
            return outputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
