package desinpattern;

/**
 * Author:WSChase
 * Created:2018/11/26
 */
public class TestSingleton1 {
    public static void main(String[] args) {
    Singleton1 singleton1=Singleton1.getInstance();//1
    Singleton1 singleton2=Singleton1.getInstance();//1
        Singleton1 singleton3=Singleton1.getInstance();//1
        System.out.println(String.valueOf(singleton1 == singleton3));
    }
}
