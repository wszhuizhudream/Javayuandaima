package cn.shuju.java;

import java.io.IOException;

//����Ŀ��
//1.java��ʶ����ؼ���
//2.java�������ͻ���
//3.java�����
//������ͱ�����������java�ı�׼�����淶Ϊ���շ塱������
//�����������������Դ�д��ĸ��ͷ�����ʣ���������ɶ��������ɣ�
//��ÿ�����ʵ�����ĸ��д�����ң�Դ�ļ����ļ����빫�����������ͬ��
//���ڱ��������ֻ����һ��������ȫ��Сд������������ɶ���������
//��ӵڶ������ʿ�ʼ��ÿ�����ʵ�����ĸ��д��
public class DataType {
//	public int a;
public static void main(String[] args) throws IOException {
//	int num1=10;
//	int num2=10;
//	int num=0;
//	num=num1+num2;
//	System.out.println("������Ϊ��"+num);
//	System.out.println(11+1l);
	
//�������͵�ǿת����ʧ��
//	long num=2147483648l;
//	int result=(int)num;
//	System.out.println(result);
	
//��Ҫ˵��
//��������Ĭ��ֵ������Ĭ��ֵ��main��������Ч
	
//	int num;
//	System.out.println(num);
//���򱨴�numδ��ʼ��
//�������ݵ�Ĭ��ֵ��Ҫ�������ܿ���
	
//	DataType d1=new DataType();
//	System.out.println(d1.a);//���Կ���Ĭ��ֵ
	
	
	
//	int i=300;
//	byte b=(byte)i;
//	System.out.println(b);
	
	
//	float f1=1.1f;
//	double a=1.1*1.1;
//	System.out.println(a);
	
//�ַ��������͵�ת��
//	char c='A';
//	int a=c;//С����ת��Ϊ�����ͣ��Զ�ת��
//	System.out.println(a);
//	//��д��ĸ ��A-Z����65����90
//	//Сд��ĸ ��a-z����97����122
//	//int��ת��Ϊchar������Ҫǿת��
//	//java��ʹ��Unicode���루һ���������Բ���ASCII�룩��ʹ��
//	//16���Ʊ��룬���Ա����κ�������Ϣ���������ģ������java����
//	//��������֧�ֱȽϺá�
	
//	int num1=10;
//	double num2=10.5;
//	String num="������"+num1+num2;//��String�����¡�+��
//	                              //�������ӷ��ţ�
//	String num3="������"+(num1+num2);
//	System.out.println(num);
//	System.out.println(num3);
	
//	System.out.println("5"+2);
	
	
	
	
	
	
//3-JavaSE֮�����߼����ƺͷ����Ķ���
//	int line=10;
//	for(int x=0;x<line;x++){
//		for(int y=0;y<line-x;y++){
//			System.out.println(" ");
//		}
//		for(int z=0;z<x;z++){
//			System.out.println("* ");
//		}
//		System.out.println();
//	}
	
	

//switch����
//	System.out.println("�������ַ���");
//	char x=(char)System.in.read();
//	switch(x){
//	case 'a':{
//		System.out.println("�һ�������");
//	}
//	case 'b':{
//		System.out.println("�鿴��Щ");
//	}
//	default:{
//		System.out.println("�������ϵ");
//	}
//   }
	//ѭ��ʹ�ù���
	//1.���ڲ�֪��ѭ��ִ�д���������֪��ѭ�����������ģ�ʹ��while
	//2.��ȷ֪��ѭ����������forѭ��
	
	
//2��ϰ
////1.ʹ��forѭ����ӡ�˷��ھ���
//	for(int i=1;i<10;i++)
//	{for(int j=1;j<=i;j++)
//	{
//		int s=i*j;
//		System.out.print(i+"*"+j+"="+s+" ");
//	}
//	System.out.println();
//	}
	
	
//2.�ݹ�ʵ��60��
	System.out.println(factorial(60));
  }
public static int factorial(int num){
	if (num==1){
		return num;
	}else{
	return num*factorial(num-1);
	}
}
}

