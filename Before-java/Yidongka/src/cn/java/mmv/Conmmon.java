package cn.java.mmv;

import java.text.DecimalFormat;

public class Conmmon {
public static String dataFormat(double data){
	DecimalFormat formatData = new DecimalFormat("0.0");
	return formatData.format(data);
}
public static double sub(double num1,double num2){
	return(num1*10-num2*10)/10;
}
}
