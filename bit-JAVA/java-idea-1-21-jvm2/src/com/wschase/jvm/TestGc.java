package com.wschase.jvm;

/**
 * Author:WSChase
 * Created:2019/1/21
 */
public class TestGc {
    private Object instance;//这个就是用来计数引用次数的

    private byte[] bigSize=new byte[2*1024*1024];

    public static void main(String[] args) {
        TestGc testGc1=new TestGc();
        TestGc testGc2=new TestGc();

        //相互引用
        testGc1.instance=testGc2;
        testGc2.instance=testGc1;

        //对象设置为null
        testGc1=null;
        testGc2=null;

        //手动gc
        System.gc();
    }
}
