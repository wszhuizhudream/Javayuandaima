package com.wschase.javase.revise1.array;

/**方法修改数组
 * Author:WSChase
 * Created:2019/3/15
 */
public class Test2 {
    public static void main(String[] args) {
        int[] data=init();
        bigger(data);
        printArray(data);
    }

    private static void bigger(int[] data) {
        for(int i=0;i<data.length;i++){
            data[i]*=5;
        }
    }

    private static void printArray(int[] data) {
        //打印数组
        for(int i=0;i<data.length;i++){
            System.out.println(data[i]);
        }
    }

    private static int[] init() {
        return new int[] {1,2,3,4,5};//匿名数组
    }
}
