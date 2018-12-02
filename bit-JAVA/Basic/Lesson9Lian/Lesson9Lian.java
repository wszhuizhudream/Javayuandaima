//练习
//模板设计模式：抽象类的一个实际应用场景。采用抽象类来实现模板设计
//1.星巴克咖啡冲泡法
//将水煮沸
//用沸水冲泡咖啡
//将咖啡倒进杯子
//加糖和牛奶
//2.星巴克茶冲泡法
//将水煮沸
//用沸水浸泡茶叶
//把茶倒进杯子
//加柠檬

// //（1）普通思维：
// //对于上面两个过程进行分析我们可以发现，它们有许多的共同之处：
// //就是前面的过程基本是一致的，只是在最后的添加东西少许部分不同
// //首先，将这两个过程抽象为类：(下面是我们的正常思维模式就是将两个过程抽象为两个类，在两个类中实现自己的过程)
// class Coffee{ 
// //将水煮沸
// public void boilwater(){
	// System.out.println("将水煮沸");
// }
// //用沸水冲泡咖啡
// public void coffeeBoilwater(){
	// System.out.println("用沸水冲泡咖啡");
// }
// //将咖啡倒进杯子
// public void putCoffee(){
	// System.out.println("将咖啡倒进杯子");
// }
// //加糖和牛奶
// public void putSuger(){
	// System.out.println("加入糖或者牛奶");
// }

// }


// class Tea{
// //将水煮沸
// public void boilwater(){
	// System.out.println("将水煮沸");
// }
// //用沸水浸泡茶叶
// public void teaBoilwater(){
	// System.out.println("用沸水浸泡茶叶");
// }
// //把茶倒进杯子
// public void putTea(){
	// System.out.println("把茶倒进杯子");
// }
// //加柠檬
// public void putLemmon(){
	// System.out.println("加柠檬");
// }
// }

// public class Lesson9Lian{
	// public static void main(String[] args){
		// //冲一杯咖啡
		// Coffee coffee=new Coffee();
		// coffee.boilwater();
		// coffee.coffeeBoilwater();
		// coffee.putCoffee();
		// coffee.putSuger();
		
	// System.out.println("-----------------------");
		
		// //泡一杯茶
		// Tea tea=new Tea();
		// tea.boilwater();
		// tea.teaBoilwater();
		// tea.putTea();
		// tea.putLemmon();
	// }
// }

// //（2）采用模板设计模式
// //对于冲咖啡和泡茶前面三个步骤是基本相同的，经过分析我们将所有的方法都放在一个抽象类中，
// //并且将这些所有的方法都作为泡茶或者泡咖啡的准备工作，定义一个prepar()方法，里面调用这些不同的步骤。
// //将相同的方法直接定义为普通方法放在抽象类中，将不同的方法定义为抽象方法，让子类去实现它，通过自己的方式。
// //将上述过程抽象为：
// //将水煮沸
// //用水冲泡
// //将饮料放进杯中
// //加入调料
// abstract class drinkBeverage{
	// final void prepar(){//我们不希望这个制作过程被子类修改，所以用final来修饰
		// boilwater();
		// brew();
		// putintoCup();
		// addSpices();
	// }
		// //下面将通用的方法实现以下，将不是通用的方法定义为抽象方法
		 // public void boilwater(){
			// System.out.println("将水煮沸");
		// }
	     // public void putintoCup(){
			// System.out.println("将饮料放入杯中");
		// }
		// public abstract void brew();
		// public abstract void addSpices();
		
// }
// //下面分别实现咖啡和泡茶类
// class Coffee extends drinkBeverage{
	// public void brew(){
		// System.out.println("用水冲泡咖啡");
	// }
	// public void addSpices(){
		// System.out.println("加糖");
	// }
// }
// class Tea extends drinkBeverage{
	// public void brew(){
		// System.out.println("用水冲泡茶叶");
	// }
	// public void addSpices(){
		// System.out.println("加柠檬");
	// }
// }
// public class Lesson9Lian{
	// public static void main(String[] agrs){
		// System.out.println("制作咖啡");
		// Coffee coffee=new Coffee();
		// coffee.prepar();
		// System.out.println("-------------------");
		// System.out.println("制作茶");
		// Tea tea=new Tea();
		// tea.prepar();
		
	// }
// }




//（3）对于上面的方法我们可以继续修改第四部，对于添加调料这个步骤有些人是需要的，但是有些人并不需要
import java.util.Scanner;
abstract class drinkBeverage{
	final void prepar(){//我们不希望这个制作过程被子类修改，所以用final来修饰
		boilwater();
		brew();
		putintoCup();
		
		if(customerWantsAddSpices()){
			addSpices();
		}
	}
		//下面将通用的方法实现以下，将不是通用的方法定义为抽象方法
		public abstract void brew();
		public abstract void addSpices();

		 public void boilwater(){
			System.out.println("将水煮沸");
		}
	     public void putintoCup(){
			System.out.println("将饮料放入杯中");
		}
		//下面这个方法也叫做钩子方法
		public boolean customerWantsAddSpices(){
			return true;//默认为true，添加调料
		}		
}
//下面分别实现咖啡和泡茶类
class Coffee extends drinkBeverage{
	public void brew(){
		System.out.println("用水冲泡咖啡");
	}
	public void addSpices(){
		System.out.println("加糖");
	}
	
	//子类覆写钩子方法，实现自定义功能(通过用户输入实现是否添加调料)
	public boolean customerWantsAddSpices(){
		String answer=getUserInput();
		if(answer.equals("y")){
			return true;
		}else {
			return false;
		}
	}
	public String getUserInput(){
		String answer=null;
System.out.println("您想要在咖啡中加入牛奶或唐糖吗？(y/n)");		
		Scanner scanner=new Scanner(System.in);
		answer=scanner.nextLine();
		return answer;
	}
}
class Tea extends drinkBeverage{
	public void brew(){
		System.out.println("用水冲泡茶叶");
	}
	public void addSpices(){
		System.out.println("加柠檬");
	}
}
public class Lesson9Lian{
	public static void main(String[] agrs){
		System.out.println("制作咖啡");
		Coffee coffee=new Coffee();
		coffee.prepar();
		System.out.println("-------------------");
		System.out.println("制作茶");
		Tea tea=new Tea();
		tea.prepar();
		
	}
}

















