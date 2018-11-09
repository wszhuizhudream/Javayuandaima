package cn.renull.vo;

import java.util.Scanner;

public class MyTest {
    public static void main(String[] args) throws CloneNotSupportedException {
//    	Student s=new Student();
//      String r=s.eat("ab", "cd");
//	    System.out.println(r);
	  
    	
    	//MyTest m=new MyTest();
    	//m.clone(); 克隆  创建一个副本
    	//判断当前对象和你传入的参数的对象地址是否相同
        //m.equals(obj)；
    	//m.finalize();在销毁当前对象时调用的方法
    	//m.getClass(); 得到类的类型
    	//m.hashCode();得到当前对象在内存中的标识码
    	//m.notify(); 唤醒当前线程
    	//m.notifyAll(); 唤醒当前所有线程
    	//m.toString();将当前对象转换成字符串
    	//m.wait();让当前线程处于等待状态
    	
//    	Student s=new Student();
//    	Student s1=(Student) s.clone();
//    	
//    	String str=s1.eat("aa", "ww");
//    	System.out.println(str);
    	
//    	Student s1=s;
    	
    	
    	
//    	if(s.equals(s1)){
//    		System.out.println("地址相等");
//    	}else{
//    		System.out.println("不相等");
//    	}
    	
/*    	
    	Student s=new Student();
    	Student s1=new Student();
    	
    	s=s1;
    	//建议JVM回收垃圾(gc是垃圾回收机制)
    	System.gc();
    	//回收的时候虚拟机不能退  虚拟机存在垃圾就存在
    	Scanner input=new Scanner(System.in);
    	System.out.println("请输入内容");
    	String content=input.next();
    	Student s=new Student();
    	Student s1=new Student();
    	s=s1;
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
 */
    	Student s=new Student();
    	Student s1=new Student();
    	String str=s.toString();
    	String str1=s1.toString();
        System.out.println(str);
        System.out.println(str1);
    }
}
