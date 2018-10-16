package cm.guanxi.lizi;

public class Grandson extends Personson {
	public void job(){
		System.out.println("Grandson实现job()");
	}
	public void eat(){
		System.out.println("Grandson实现eat()");
	}
	public static void main(String[] args) {
		Person ps = new Grandson();
		ps.eat();
		ps.job();
		Grandson gs = new Grandson();
		String str=gs.showPersonson("你好", 25);
		System.out.println(str);
	}
}
