package cn.baozhuang.www;

public class TestString {
public static void main(String[] args) {
	//
	String s="abcdefgh";
	//根据索引找字符
	System.out.println(s.charAt(1));
	//链接字符串，相当于+
	System.out.println(s.concat("ABC"));
    //判断两个字符串是否一致，区分大小写
	System.out.println(s.equals("abc"));
	//判断两个字符串是否一致，不区分大小写
	System.out.println(s.equalsIgnoreCase("ABC"));
	//是否包含字符串
	System.out.println(s.contains("abc"));
	//判断后缀名是否相等
	System.out.println(s.endsWith("java"));
	//根据字符找索引，找不到返回-1
	System.out.println(s.indexOf("a"));
	//判断字符串是否为空
	System.out.println(s.isEmpty());
	//注意：String s="";此时已经开辟空间了
	//重复出现的字符串最后一次出现的位置的索引
	System.out.println(s.lastIndexOf("c"));
	//替换当前字符串的所有内容
	System.out.println(s.replace("a", "d"));
	//判断当前字符串的长度
	System.out.println(s.length());
	//截取字符串，包含第4个位置
	System.out.println(s.substring(4));
	//截取字符串，包前不包后  常用
	System.out.println(s.substring(2, 5));
	//将字符串的大写转换成小写
	System.out.println(s.toLowerCase());
	//将字符串的小写转换成大写
	System.out.println(s.toUpperCase());
	
	
	
	
	
	
	
	
	
	
	
	
}
}
