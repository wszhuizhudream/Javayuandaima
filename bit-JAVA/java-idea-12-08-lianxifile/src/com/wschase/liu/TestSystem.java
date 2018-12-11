package com.wschase.liu;

import java.util.Map;
import java.util.Properties;

/**系统属性和环境变量属性（很重要）
 * Author:WSChase
 * Created:2018/12/9
 */
public class TestSystem {
    public static void main(String[] args) {

    //1.系统属性:Properties properties=System.getProperties();->通过定义的这个对象类调用它的方法
        Properties properties=System.getProperties();
        //常用的系统属性
        System.out.println("常见系统属性：");
        //（1） user.home
        String userHome=(String)properties.get("user.home");
        System.out.println(userHome);
        //（2） user.dir
        String userDir=(String)properties.get("use.dir");
        System.out.println(userDir);
        //（3） java.home
        String javaHome=(String)properties.get("java.home");
        System.out.println(javaHome);
        //（4） path.separator
        String pathSeparator=(String)properties.get("path.separator");
        System.out.println(pathSeparator);
        //（5） file.separator
        String fileSeparator=(String)properties.get("file.separator");
        System.out.println(fileSeparator);
        System.out.println("-------------------------");
        System.out.println("常见系统环境变量：");
    //2.系统的话你就环境变量
    Map<String,String> env=System.getenv();
    for(Map.Entry<String,String> entry:env.entrySet()){
        System.out.println(entry.getKey()+"="+entry.getKey());
    }
         //系统常见的环境变量
         //(1)JAVA_HOME
        System.out.println(System.getenv("JAVA_HOME"));
         //(2)SystemDrive
        System.out.println(System.getenv("SystemDrive"));
        //(3)Path
        System.out.println(System.getenv("Path"));
        //(4)ProgramW6432
        System.out.println(System.getenv("ProgramW6432"));
        //TEMP
        System.out.println(System.getenv("TEMP"));
        //NUMBER_OF_PROCESSORS
        System.out.println(System.getenv("NUMBER_OF_PROCESSORS"));

    }

}
