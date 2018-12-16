package com.bittech.io;

import java.io.File;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Author: secondriver
 * Created: 2018/12/9
 */
public class TestSystem {
    
    
    public static void systemProperties() {
        //系统属性
        Properties properties = System.getProperties();
        //常用的系统属性
        //user.home
        //user.dir
        //java.home
        //path.separator
        //file.separator
        String userHome = (String) properties.get("user.home");
        System.out.println(userHome);
    }
    
    public static void code2() {
        //系统的环境变量
//        Map<String, String> env = System.getenv();
//        for (Map.Entry<String, String> entry : env.entrySet()) {
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }
        
        //JAVA_HOME
        //SystemDrive
        //Path
        //ProgramW6432
        //TEMP
        //NUMBER_OF_PROCESSORS
        System.out.println(System.getenv("JAVA_HOME"));
        
        //临时目录文件
        File tempFile = Paths.get(
                System.getenv("TEMP"),
                "abc.txt")
                .toFile();
        
        System.out.println(tempFile.getAbsolutePath());
    }
    
    public static void main(String[] args) {
    
    }
}
