package cn.reun.com;

public class Byte {
public static void main(String[] args){
	//byte:字节型，用一个字节来表示整数值
	byte x=22;
	byte y=022;
	byte z=0x22;
	System.out.println("转化成十进制，x="+x);
	System.out.println("转化成十进制，y="+y);
	System.out.println("转化成十进制，z="+z);
	/**short:用两个字节表示整数值
	*int:用四个字节表示整数值
	*long:用8个字节表示整数值，它与其他三个不同，
	*在长整型的数据后面有一个"L"字母。
	*/
    long m=510L;
    System.out.println("m="+m);
/**
 * 1.字符型
 *字符型，占两个字节
 * 必须以单引号括起来为一个字符：'A'
 * 双引号括起来的为字符串："A"
 * 2.单精度浮点型
 * 占4个字节，有效数字最长为7位，包括整数和小数部分
 * 在单精度浮点型数据后面有一个标志性符号“F”或者“f”。
 * 注意：系统会将没有标志性的小数自动默认为双精度浮点型
 * 3.双精度浮点型
 * 占8个字节，有效数字最长为15位，包括整数和小数部分
 *  在双精度浮点型数据后面有一个标志性符号“D”或者“d”，也可以不加。
 *4.布尔型
 *在布尔型数据中只会输出true或false。
 */
}
}
