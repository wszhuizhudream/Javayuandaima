package com.wschase.javase.revise1.array;

/**数组的常见案例
 * Author:WSChase
 * Created:2019/3/15
 */
public class Test4 {

    //1.计算数组中最大值
    public static int arrayMax(int[] data){
            int max=data[0];
        for(int i=1;i<data.length;i++){
            if(max<data[i]){
                max=data[i];
            }
        }
        return max;
    }

    //2.计算数组中最小值
    public static int arrayMin(int[] data){
        int min=data[0];
        for(int i=1;i<data.length;i++){
            if(min>data[i]){
                min=data[i];
            }
        }
        return min;
    }

    //3.计算数组之和
    public static int arraySum(int[] data){
        int sum=0;
        for(int i=0;i<data.length;i++){
            sum+=data[i];
        }
        return sum;
    }

    //4.数组拼接
    public static int[] arrayJoin(int[] a,int[] b){
        //a={1,2,3,4}  b={5,6,7}  ==>c={1,2,3,4,5,6,7}
        int temp=a.length+b.length;
        int[] c=new int[temp];//首先初始化一个数组用来存放拼接以后的数组
        for(int i=0;i<a.length;i++){
            c[i]=a[i];
        }
        for(int i=0;i<b.length;i++){
            c[a.length+i]=b[i];
        }
        return c;
    }

    //5.数组截取：半闭半开区间
    public static int[] arraySub(int[] a,int start,int end){
        if(a==null){
            throw new IllegalArgumentException("data must not be null");
        }

        if(start>end){
            throw new IllegalArgumentException("start>end");
        }
        if (start > a.length) {
        throw new IllegalArgumentException("start must be < a.length");
        }

        if(end-start<a.length){
            throw new IllegalArgumentException("sub must be <a.length");
        }

        int[] b=new int[end-start];
        for(int i=start;i<end;i++){
            //主要是要知道这个开始的地方和结束的地方，知道它们的关系
            b[i-start]=a[i];
        }
        return b;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,5,6,2,8,9,4,7,3,10};
        int[] a = new int[]{1,2,3};
        int[] b= new int[] {4,5,6};
        int max = arrayMax(data);
        System.out.println("最大值："+max);
        int min = arrayMin(data);
        System.out.println("最小值为："+min);
        int sum = arraySum(data);
        System.out.println("数组之和为："+sum);
        int[] join = arrayJoin(a,b);
        System.out.println("拼接后的数组为："+join);
        int[] sub = arraySub(a,2,4);
        System.out.println("截取后数组为："+sub);


    }

}
