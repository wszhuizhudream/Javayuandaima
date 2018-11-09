package cn.debt.java;

public class Test {
	public static void main(String[] args){
	Student s=new Student();
//	s.number=510;
//	s.name="王偲";
//	s.sex="女";
//	s.age=20;
//	s.study();
	Student s1=new Student();
	s1.number=525;
	s1.name="康波涛";
	s1.sex="男";
	s1.age=22;
	s=s1;//将s1的地址赋给s,此时s与s1访问同一个空间，所以输出相同的值
	s.study();
	s1.study();
	}
}
