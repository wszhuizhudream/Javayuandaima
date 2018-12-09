package com.wschase.file;

import java.io.*;
import java.nio.file.Paths;

/**
 * Author:WSChase
 * Created:2018/12/8
 */
//将两个文件进行合并
public class TestAddFile {
    public static void main(String[] args) throws IOException {
        File[] files=new File[]{
                new File("E:"+File.separator+"learn"+File.separator+"javaio"+File.separator+"data1.txt"),
                new File("E:"+File.separator+"learn"+File.separator+"javaio"+File.separator+"data2.txt")
        };
        String[] data=new String[2];
        for(int i=0;i<files.length;i++){
            data[i]=readFile(files[i]);//这是我们自己定义的一个方法
        }
        StringBuffer buf=new StringBuffer();
        String contentA[]=data[0].split(" ");
        String contentB[]=data[1].split(" ");
        for(int i=0;i<contentA.length;i++){
            buf.append(contentA[i]).append("(").append(contentB[i]).append(")").append(" ");
        }
        System.out.println(buf);
    }

    private static String readFile(File file) throws IOException {
        if(file.exists()){
            InputStream input=new FileInputStream(file);
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            int len=-1;
            byte[] data=new byte[10];
            while((len=input.read(data))!=-1){
                //将数据保存在bos中
                bos.write(data,0,len);
            }
            bos.close();
            input.close();
            return new String(bos.toByteArray());
        }
        return null;
    }
}
