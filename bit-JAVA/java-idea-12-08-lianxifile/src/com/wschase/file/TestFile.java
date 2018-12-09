package com.wschase.file;

import java.io.File;
import java.io.IOException;

/**File文件练习
 * Author:WSChase
 * Created:2018/12/9
 */
public class TestFile {
    public static void code1() throws IOException {

        File file=new File("E:"+ File.separator+"learn"+File.separator+"javaio"+File.separator+"data1.txt");
        if(file.exists()){
            file.delete();
        }else{
            file.createNewFile();
        }
    }
    public static void main(String[] args) throws IOException {
        TestFile.code1();
    }
}
