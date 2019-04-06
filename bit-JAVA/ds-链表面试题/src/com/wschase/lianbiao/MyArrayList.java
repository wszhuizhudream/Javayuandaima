package com.wschase.lianbiao;

/**
 * Author:WSChase
 * Created:2019/4/6
 */

public class MyArrayList {
    private int[] array;
    private int size;

    //头插
    public void pushFront(int v){
        ensureCapacity();
        for(int i=this.size;i>=1;i--){
            this.array[i]=this.array[i-1];
        }
        this.array[0]=v;
        this.size++;

    }

    //头删
    public void popFront(){
        for(int i=0;i<this.size-2;i++){
            array[i]=array[i+1];
        }
        //数组中的元素少了一个，所以长度需要减一
        --this.size;
    }

    //尾插
    public void pushBack(int v){

    }

    private void ensureCapacity() {
        if(this.size<array.length){
            return ;
        }
        int newCapacity=array.length*2;
        int[] newArray=new int[newCapacity];
        for(int i=0;i<this.size;i++){
            newArray[i]=array[i];
        }
        //将新的地址赋值给原来的数组，让原来的数组继续可以找到存放的数据
        array=newArray;
    }
}
