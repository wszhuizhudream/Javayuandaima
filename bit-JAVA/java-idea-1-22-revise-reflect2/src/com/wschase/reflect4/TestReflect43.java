package com.wschase.reflect4;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;

import java.io.FileInputStream;
import java.io.InputStream;

/**自定义类加载器
 * Author:WSChase
 * Created:2019/1/23
 */
////(1)观察默认类加载器
//    class Member2{
//    @Override
//    public String toString() {
//        return "Member2";
//    }
//}
//public class TestReflect43 {
//    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        System.out.println(Class.forName("Member").getClassLoader().loadClass("Member").newInstance());
//    }
//}

//(2)自定义类加载器
 class MyClassLoader extends ClassLoader{
    /**
     * 实现一个自定义的类加载器，传入类名称，通过指定路径加载
     * @param className 类名称
     * @param 返回的Class对象
     * @throw Exception
     */
    public Class<?> loadData(String className){
        //加载类文件的信息
        byte[] classData=this.loadClassData();
        return super.defineClass(className,classData,0,classData.length);
    }

    /**
     * 通过指定的文件路径进行类的文件加载，实际就是进行二进制文件读取
     * @return 类文件数据
     * @throws Exception
     */
    private byte[] loadClassData(){
        //InputStream input=new FileInputStream("");
    }
}




public class TestReflect43{

}
//在类加载器中我们应该注意：
//比较两个类的前提条件：必须是同一个类加载器加载的。否则是没有意义的。即使连个类
//来源于同一个Class文件，被同一个虚拟机加载，只要加载它们的类加载器不同，那么这两个类注定不相等
