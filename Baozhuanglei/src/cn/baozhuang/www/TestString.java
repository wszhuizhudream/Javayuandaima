package cn.baozhuang.www;

public class TestString {
public static void main(String[] args) {
	//
	String s="abcdefgh";
	//�����������ַ�
	System.out.println(s.charAt(1));
	//�����ַ������൱��+
	System.out.println(s.concat("ABC"));
    //�ж������ַ����Ƿ�һ�£����ִ�Сд
	System.out.println(s.equals("abc"));
	//�ж������ַ����Ƿ�һ�£������ִ�Сд
	System.out.println(s.equalsIgnoreCase("ABC"));
	//�Ƿ�����ַ���
	System.out.println(s.contains("abc"));
	//�жϺ�׺���Ƿ����
	System.out.println(s.endsWith("java"));
	//�����ַ����������Ҳ�������-1
	System.out.println(s.indexOf("a"));
	//�ж��ַ����Ƿ�Ϊ��
	System.out.println(s.isEmpty());
	//ע�⣺String s="";��ʱ�Ѿ����ٿռ���
	//�ظ����ֵ��ַ������һ�γ��ֵ�λ�õ�����
	System.out.println(s.lastIndexOf("c"));
	//�滻��ǰ�ַ�������������
	System.out.println(s.replace("a", "d"));
	//�жϵ�ǰ�ַ����ĳ���
	System.out.println(s.length());
	//��ȡ�ַ�����������4��λ��
	System.out.println(s.substring(4));
	//��ȡ�ַ�������ǰ������  ����
	System.out.println(s.substring(2, 5));
	//���ַ����Ĵ�дת����Сд
	System.out.println(s.toLowerCase());
	//���ַ�����Сдת���ɴ�д
	System.out.println(s.toUpperCase());
	
	
	
	
	
	
	
	
	
	
	
	
}
}
