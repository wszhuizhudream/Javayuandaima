package cn.debt.java;

public class Test {
	public static void main(String[] args){
	Student s=new Student();
//	s.number=510;
//	s.name="����";
//	s.sex="Ů";
//	s.age=20;
//	s.study();
	Student s1=new Student();
	s1.number=525;
	s1.name="������";
	s1.sex="��";
	s1.age=22;
	s=s1;//��s1�ĵ�ַ����s,��ʱs��s1����ͬһ���ռ䣬���������ͬ��ֵ
	s.study();
	s1.study();
	}
}
