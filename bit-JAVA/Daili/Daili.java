//代理设计模式
//送花：张三需要送花给李四，但是又不要自己送花，通过快递员给李四送花
interface SendFlower{
	public void sendFlower();
}
//这是我们真正的类，就是主要的
class BoyFirend implements SendFlower{
	public void sendFlower(){
		System.out.println("张三送给李四的花");
	}
}
//这是我们的代理，快递员
class ProxyBoyFirend implements SendFlower{
	//首先我们需要知道的是，快递源在给李四送花的过程中，需要先打电话确认
	//在确认有人的情况下，再去给李四送花——代替张三实现这个过程
	//送完花以后还需要签收
	private SendFlower sendPeople;//这个是真正的操作业务
	public ProxyBoyFirend(SendFlower sendPeople){//这个代理类的构造方法我们需要将真正业主的名字传进去
		this.sendPeople=sendPeople;
	}
	public void Tel(){
		System.out.println("打电话确认这个时间段是否有人");
	}
	public void Write(){
		System.out.println("收到花以后签字");
	}
	//这个方法是为了让这个代理业务形成一个流水线，只要创建对象那么就将这个方法执行一下
	public void sendFlower(){//代理对象对接口中抽象方法的重写就是将整个过程都写进这个方法中
		this.Tel();
		this.sendPeople.sendFlower();//真实操作业务：这个业务的定义是在接口中的，但是我们在真正的操作者中
		                             //对他进行了实例化，所以我们只能通过真正的操作者才能调用这个函数。
	    this.Write();
	}
}
class Factory{
	public static SendFlower getInstance(){//这个方法我们是为了实现返回真正的对象
		return new ProxyBoyFirend(new BoyFirend());
	}
}
public class Daili{
	public static void main(String[] args){
		//在这我们只需要通过代理对象来操作这个过程即可
		SendFlower sd=Factory.getInstance();
	    sd.sendFlower();
	}
}
