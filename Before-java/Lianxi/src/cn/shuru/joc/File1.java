package cn.shuru.joc;

import java.io.File;
import java.io.FileInputStream;

public class File1 {
public static void main(String[] args)throws Exception {
	File f=new File("d:\\filetest\\file.txt");
	FileInputStream fis=new FileInputStream(f);
	char ch;
	for(int i=0;i<f.length();i++)
	{
		ch=(char)fis.read();
		System.out.println(ch);
	}
	fis.close();
}
}
