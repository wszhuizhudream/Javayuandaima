package com.wschase.xianchengjianjie;

/**2.Runnable接口实现多线程----通过代理模式来实现的，这样保证了开闭原则
 * 使用多线程方法
 * 1.复用业务逻辑
 * 2.实现runnable接口，可以继续实现接口
 * Author:WSChase
 * Created:2019/1/8
 */
public class PrintInfo {
    //这是一个普通任务
    public void print(Object ... args){
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
    }

    public static void main(String[] args) {
       // new PrintInfo().print("hello","world");
        //使用多线程访问----通过Runnable
        PrintInfo task=new PrintInfo();
//        Runnable runnable=new PersonInfo(task);
//        //public Thread(Runnable target)----》这是Thread的构造方法
//        Thread thread=new Thread(runnable);//Thread方法里面需要RUnnable接口的实例化对象
//        thread.start();

        //(2)采用lambda表达式
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                //直接实现了我们代理类里面的功能，不需要再创建一个类了
                task.print("hello","nihao");
            }
        });
        thread.start();
    }
}

//这是个普通的类实现Runnable接口，这个类就是代理类，代理模式
class PersonInfo implements Runnable{
    private final PrintInfo task;

    public PersonInfo(PrintInfo task) {
        this.task = task;
    }

    @Override
    public void run() {
        this.task.print("hello","java","best");
    }
}