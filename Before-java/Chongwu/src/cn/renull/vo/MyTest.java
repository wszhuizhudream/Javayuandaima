package cn.renull.vo;

import java.util.Scanner;

public class MyTest {
    public static void main(String[] args) throws CloneNotSupportedException {
//    	Student s=new Student();
//      String r=s.eat("ab", "cd");
//	    System.out.println(r);
	  
    	
    	//MyTest m=new MyTest();
    	//m.clone(); ��¡  ����һ������
    	//�жϵ�ǰ������㴫��Ĳ����Ķ����ַ�Ƿ���ͬ
        //m.equals(obj)��
    	//m.finalize();�����ٵ�ǰ����ʱ���õķ���
    	//m.getClass(); �õ��������
    	//m.hashCode();�õ���ǰ�������ڴ��еı�ʶ��
    	//m.notify(); ���ѵ�ǰ�߳�
    	//m.notifyAll(); ���ѵ�ǰ�����߳�
    	//m.toString();����ǰ����ת�����ַ���
    	//m.wait();�õ�ǰ�̴߳��ڵȴ�״̬
    	
//    	Student s=new Student();
//    	Student s1=(Student) s.clone();
//    	
//    	String str=s1.eat("aa", "ww");
//    	System.out.println(str);
    	
//    	Student s1=s;
    	
    	
    	
//    	if(s.equals(s1)){
//    		System.out.println("��ַ���");
//    	}else{
//    		System.out.println("�����");
//    	}
    	
/*    	
    	Student s=new Student();
    	Student s1=new Student();
    	
    	s=s1;
    	//����JVM��������(gc���������ջ���)
    	System.gc();
    	//���յ�ʱ�������������  ��������������ʹ���
    	Scanner input=new Scanner(System.in);
    	System.out.println("����������");
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
