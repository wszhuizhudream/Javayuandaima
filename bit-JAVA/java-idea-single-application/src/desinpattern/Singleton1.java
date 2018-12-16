package desinpattern;

/**
 * 1.一个类只允许实例化一个对象
 * 2.立即初始化->饿汉式单例->可以立即加载，线程安全，内存可能会浪费（如果没有人去调用这个函数，那么这个函数中已
 * 经开辟了空间了，就会浪费）
 * Author:WSChase
 * Created:2018/11/26
 */
//1.静态常量
public class Singleton1 {
    //将这个类的构造方法定义为私有的，就只能创建一个对象
    private static final Singleton1 INSTANCE =new Singleton1();//1
    private  Singleton1(){

    }
    public static Singleton1 getInstance() {
        return INSTANCE;
    }

}
//如果采用静态常量的写法，会造成浪费内存

////3.（线程不安全）
//public class Singleton1{
//    private static Singleton1 singleton;
//    private Singleton1(){}
//    public static Singleton1 getInstance(){
//        if(singleton==null){
//            singleton=new Singleton1();
//        }
//        return singleton;
//    }
//}
////这种写法之所以是线程不安全的是因为，当我们同时有多个线程访问
////if(singleton==null)这个语句的时候，同时发现对象并没有实例化
////这时候多个线程就会进行实例化，那么就会实例化多个对象，造成不安全
////4.线程安全，同步方法
//public class Singleton1{
//    private static Singleton1 singleton;
//    private Singleton1(){}
//    public static synchronized Singleton1 getInstance(){
//        if(singleton==null){
//            singleton=new Singleton1();
//        }
//        return singleton;
//    }
//}
////对于第三种情况之所以会出现线程不安全的原因就是因为线程不同步，
////所以我们用synchronized进行修饰方法就可以保证这个方法是线程同步的了，
////这样自然就解决了线程不安全的问题。但是这样的写法也会有弊端，即使效率太低了，
////因为如果多个线程同时访问这个语句，那么就意味着一次只能有一个线程可以进行实例化对象，
////剩下的线程就必须等待。

////5.线程安全，同步代码块
//public class Singleton1{
//    private static Singleton1 singleton;
//    private Singleton1(){}
//    public static Singleton1 getInstance(){
//        if(singleton==null){
//            synchronized (Singleton1.class){
//                singleton=new Singleton1();
//            }
//        }
//        return singleton;
//    }
//}
////这种同步代码块的写法并不能保证线程安全，它同样会出现和第3种一样的情况，所以它并不可取。
////6.双重检查——一定要掌握
//public class Singleton1{
//    private static volatile Singleton1 singleton;
//    private Singleton1(){
//
//    }
//    public static Singleton1 getInstance(){
//        //双重检查
//        if(singleton==null){
//            synchronized (Singleton1.class){
//                if(singleton==null){
//                    singleton=new Singleton1();
//                }
//            }
//        }
//        return singleton;
//    }
//}
////这样的写法既可以保证线程安全，又提高了效率。在进行双重检查执行了两次if(singleton==null)，在第一次检查
////的时候是延迟了加载，第二次检查的时候如果卯足条件直接实例化对象。

////7.静态内部类
//public class Singleton1 {
//    private Singleton1() {
//
//    }
//
//    private static class SingletonInstance {
//        private static final Singleton INSTANCE = new Singleton();
//
//    }
//    public static Singleton getInstance(){
//        return SingletonInstance.INSTANCE;
//    }
//}
////这个方法的原理机制和饿汉式很像，只会在第一次加载类的时候初始化，JVM保证了线程的安全性，
////静态内部类方式在Sindleton1类装载的时候并不会立即实例化，而是在需要实例化时，调用getInstance方法，
////之后装载SingletonInstance类才会完成实例化。

////8.枚举
//public enum Singleton1{
//    INSTANCE;
//    public void method(){
//
//    }
//}
////可以避免多线程同步问题，而且可以防止反序列化重新创建新对象。

