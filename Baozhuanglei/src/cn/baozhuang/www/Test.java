package cn.baozhuang.www;

import java.awt.List;


/*
 * java���г��˰��л�������������������е��඼��Object������
 * ��װ�ࣺ
 * װ�䣺�ѻ�����������ת���ɶ���
 * ���䣺�Ѷ���ת���ɻ�����������
 */
public abstract class Test {
public static void main(String[] args) {
	//������װ�䷽ʽ��
	/*1.�������н�������������ת���ͽ�װ�䣨�Զ�װ�䣩
	int i=10;
	Integer ing=i;//Integer����int�İ�װ�࣬�Ͱ�������intʹ��
	      //��������һ�����࣬һ���ǻ�����������
	     //Integer�Ƕ�int�İ�װ��
	      */
	/*2.ͨ��new Integer()�ķ�ʽ��i����װ��
	int i=3;
	Integer ing1=new Integer(i);
	System.out.println(i);
	System.out.println(ing);
	*/
	//List a=new ArrayList();
	//Integer������д���������ָ�ֵ��ʽ������8�ֻ����������ͺ�String
	Integer ing1=20;
	Integer ing2=new Integer(30);
	//����дΪInteger ing2=new Integer(ing1);
	String name="���";
	String name1=new String("��˵��");
	//ע�⣺String����8�ֻ����������ͣ����ܷ��ࣨfinal��
	/*
	 * ��������ַ�ʽ��
	 * 1.ֱ�Ӷ��������
	 * Integer ing=new Integer(10);
	 * int num =ing.intValue();
	 * System.out.println(num);
	 * 2.ֱ�Ӹ�ֵ
	 * int num1=ing;
	 * System.out.println(num1);
	 */
	//��һ���ַ�������ת����int��
	//�����������õķ���һ���Ǿ�̬����
	int b=Integer.parseInt("100");//parseInt():ת����String���͵����֣����ܷź���
	Integer a1=Integer.parseInt("100");//�Զ�ת��
	System.out.println(b);
	/*
	 * double��
	 * b=2.16473223
	 * Double b1=
	 */
	/*
	 * float��
	 */
	/*
	 * boolean��
	 */
	/*
	 * short��
	 */
	/*
	 * long��
	 * Long l=22��������Ϊ�����Զ���Ϊ����int�ͣ�Ӧ����int��ص��������ͻ��װ�����
	 * Long l1=22l(��ȷ)
	 */
	/*char��
	 * ch
	char c='a';
	Character ch=c;
	Character ch1=new Character(ch);
	System.out.println(ch);
	System.out.println(ch1);
	*/
	
	/*byte��
	byte by=11;
	Byte b1=33;
	Byte b2=new Byte(44);��������Ϊ44��int���ͣ���������������������Ҫ��
	                    ���췽��һ�¡���
	 */
	
	
	
	
}
}
