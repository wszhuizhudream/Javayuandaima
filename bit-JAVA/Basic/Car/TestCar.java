public class TestCar{
	public static void main(String[] agrs){
		Car car1=new Car("红色",104789,100000);//此时创建了一个对象
		car1.khapTronPai();
		System.out.println(car1.carInfo());
	}
}