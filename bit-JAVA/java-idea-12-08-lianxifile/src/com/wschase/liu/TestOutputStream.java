package com.wschase.liu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**字节输出流（写数据）
 * Author:WSChase
 * Created:2018/12/8
 */
public class TestOutputStream {
    public static void main(String[] args) {
        Path path=Paths.get("E:","learn","javaio","data1.txt");
        File file=path.toFile();//准备好写入的文件
        try(OutputStream out=new FileOutputStream(file)){
            String msg="你好世界";
            out.write(msg.getBytes());//通过方法将字符串转化为字节数组，这样才符合参数类型
            //使用自动关闭的方法
        }catch (Exception e){

        }
    }
}
