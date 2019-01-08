package com.wschase.xianchengjianjie;

/**3.多线程的常用操作方法
 * Author:WSChase
 * Created:2019/1/8
 */
public class ThreadTool {
    //这是一个普通任务
    public void print(Object ... args){
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
    }

    public static void main(String[] args) {
        //我们的main方法就是我们的主线程
        ThreadTool task=new ThreadTool();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                //直接实现了我们代理类里面的功能，不需要再创建一个类了
                task.print("hello","nihao");
            }
        });
        thread.start();
//        //系统自定义的名字
//        System.out.println(thread.getName());
          //我们自己给线程起名字
        thread.setName("线程-处理PrintInfo");
        System.out.println(thread.getName());
    }
}

