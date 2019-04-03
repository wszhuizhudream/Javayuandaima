package com.wschase.ds.arraylist;

import java.util.Iterator;
import java.util.function.Consumer;

/**顺序表的自我实现
 * Author:WSChase
 * Created:2019/4/3
 */
public class MyarrayList<AnyType> implements Iterator<AnyType> {
    //首先定义一个默认数组的长度
    private static final int DEFAULT_CAPACITY=10;

    //定义一个数组的长度变量
    private int theSize;

    //开辟一个数组
    private AnyType[] theItems;
    //构造方法
    public MyarrayList(){
        doClear();
    }

    private void doClear() {
        theSize=0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    //每次在进行操作的时候首先需要保证我们的数组的空间是足够的
    private void ensureCapacity(int newCapacity) {
        if(newCapacity<theSize){
            //如果足够就直接返回
            return;
        }else {
            //如果不足够就重新开辟空间
            AnyType[] old=theItems;
            theItems=((AnyType[]) new Object[newCapacity]);
            for(int i=0;i<)

        }
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public AnyType next() {
        return null;
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer<? super AnyType> action) {

    }
}
