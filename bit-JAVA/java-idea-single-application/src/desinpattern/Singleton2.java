package desinpattern;

/**
 * 懒汉式：延迟实例化，线程不安全（当有多个线程同时访问的时候，同时发现是Null的时候，都会实例化一个，这时候线程就在来回变化）
 * 但是在不使用对象时可以节省内存空间
 * Author:WSChase
 * Created:2018/11/26
 */
public class Singleton2 {
    private static Singleton2 instance =null;
    private Singleton2(){

    }
    public static Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}
