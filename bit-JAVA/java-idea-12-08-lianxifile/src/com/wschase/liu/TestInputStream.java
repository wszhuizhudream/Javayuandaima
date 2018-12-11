package com.wschase.liu;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**字节输入流（读数据）
 * Author:WSChase
 * Created:2018/12/8
 */
public class TestInputStream {
    public static void main(String[] args) {
        Path path=Paths.get("E:","learn","javaio","data1.txt");
        File file=path.toFile();
        try(InputStream input=new FileInputStream(file)){
            byte[] buff=new byte[1024];
            int len=-1;
            while((len=input.read(buff))!=-1){//经过这一步之后我们的内容就已经读到这个字节数组中了
                System.out.println(new String(buff));//但是直接输出字节我们是看不懂的，所以我们将字节转化为字符串
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
