public class TestComputer{
	public static void main(String[] args){
		//创建三个对象
		Computer com1=new Computer("联想");
		Computer com2=new Computer("惠普","白色");
		Computer com3=new Computer("华为","金色",6000);
		
		//通过对象调用普通方法
		System.out.println(com1.getComputerInfo());
		System.out.println(com2.getComputerInfo());
		System.out.println(com3.getComputerInfo());
		com1.computerQ();
		
		// //通过get和set方法对他们建立对象时给定的值进行更改或者获得
		// setColor("银色");
		com1.setColor("银色");//不可以有System.out.println，因为这个函数的作用只能更改属性，不可以输出；
		System.out.println("通过get方法得到com2的类型：");
		System.out.println(com2.getType());
		
		//通过对象调用普通方法
		System.out.println("修改以后的值：");
		System.out.println(com1.getComputerInfo());
		System.out.println(com2.getComputerInfo());
		System.out.println(com3.getComputerInfo());
		com1.computerQ();
	}
}