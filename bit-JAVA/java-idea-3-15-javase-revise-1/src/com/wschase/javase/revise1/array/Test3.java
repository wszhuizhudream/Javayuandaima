package com.wschase.javase.revise1.array;

/**java对数组的支持
 * Author:WSChase
 * Created:2019/3/15
 */
public class Test3 {
    public static void main(String[] args) {
        int[] intData=new int[]{1,65,32,23,44};
        int[] data=new int[]{1,2,3,4,5,6,7,8,9};
        char[] charData=new char[]{'a','A','e','c'};
        java.util.Arrays.sort(intData);
        java.util.Arrays.sort(charData);

        //数组拷贝
        System.arraycopy(data,4,intData,1,3);

        printArray(data);
        printArray(intData);
        printArray(charData);
    }

    private static void printArray(int[] data) {
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]);
            System.out.print(" ");
        }
        System.out.println();
    }


    private static void printArray(char[] data) {
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]);
        }
        System.out.println();
    }

}
