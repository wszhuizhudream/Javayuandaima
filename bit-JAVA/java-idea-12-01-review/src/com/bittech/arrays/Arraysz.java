package com.bittech.arrays;

/**数组的练习
 * Author:WSChase
 * Created:2018/12/1
 */
//public class Arraysz {
//        //首先我们下面的所有操作都需要输出结果，进行查看，所以我们编写一个函数打印字符串
//        public static void printArray(int[] data){
//            for(int i=0;i<data.length;i++){
//                System.out.println(data[i]);
//            }
//        }
////    //1.方法返回数组:定义一个方法，这个方法专门用来生产数组返回数组
////        public static int[] init(){//因为main方法是static方法，需要调用这个函数，所以需要定义为static
////            return new int[]{1,2,3,4,5};
////        }
////    //2.方法接收数组:方法接收数组就是将数组作为参数传递给方法
////    //在printArray方法中机型打印数组的时候就已经用到了
////    //3.方法修改数组
////    public static int[] change(int[] data){
////            for(int i=0;i<data.length;i++){
////                //将数组是的元素每一个扩大5倍
////                data[i]=data[i]*5;
////            }
////            return data;
////    }
////    //4.数组排序:数组的排序直接用我们Array提供的函数即可进行排序
////    //5.数组的拷贝
////    //6.计算数组中的最大值
////    public static int arrayMax(int[] data) throws Exception {//在方法中抛出异常
////        int max = data[0];
////        for (int i = 0; i < data.length; i++) {
////            if (data[i] > max) {
////                max = data[i];
////            }
////        }
////        return max;
////    }
////        //7.计算数组中的最小值
////    public static int arrayMin(int[] data) throws Exception{
////            int min=data[0];
////            for(int i=0;i<data.length;i++){
////                if(data[i]<min){
////                    min=data[i];
////                }
////            }
////            return min;
////    }
////        //8.计算数组之和
////    public static int arraySum(int[] data){
////            int sum=data[0];
////            for(int i=1;i<data.length;i++){
////                sum+=data[i];
////            }
////            return sum;
////    }
////        //9.数组拼接
////    public static int[] joinArray(int[] data1,int[] data2){
////            int[] data3=new int[data1.length+data2.length];
////            for(int i=0;i<data1.length;i++){
////                data3[i]=data1[i];
////            }
////            for(int i=data1.length;i<data3.length;i++){
////                data3[i]=data2[i-data1.length];
////            }
////            return data3;
////    }
////        //10.数组截取(截取的时候输入截取的数组，截取的初时位置，截取的长度)
////    public static int[] subArray(int[] data,int a,int b){
////            int[] tmp=new int[b];
////            for(int i=0;i<tmp.length;i++){
////                tmp[i]=data[i+a];
////            }
////            return tmp;
////    }
////
////        public static void main (String[]args){
////            //1.方法返回数组
////        int[] data1=init();
////        printArray(data1);//打印字符串的函数
////        //2.方法接收数组
////        //3.方法修改数组
////        int[] data2=init();
////        int[] afterChange=change(data2);
////        printArray(afterChange);
////        //4.数组排序：数组的排序直接用我们Array提供的函数即可进行排序
////        int[] data3=new int[]{3,6,9,19,1,34};
////        java.util.Arrays.sort(data3);
////        //这个地方我们需要注意的是：直接通过数组的名字输出数组中的元素--》java.util.Arrays.toString(数组名)
////        System.out.println(java.util.Arrays.toString(data3));
////        //5.数组的拷贝
////        int[] data4=new int[]{1,4,6,7,9,13};
////        int[] data5=new int[]{1,2,3,4,5,6,7,8};
////        System.arraycopy(data4,2,data5,3,3);
////        printArray(data5);
////            //6.计算数组中的最大值
////            //int[] data6 = new int[]{12, 35, 89, 20};
////            int[] data6=null;
////            try{
////                int max1 = arrayMax(data6);
////                System.out.println(max1);
////            } catch (Exception e) {
////                System.out.println("数组没有进行初始化");
////            }
////            //7.计算数组中的最小值
////            int[] data7=new int[]{21,34,25,32,12};
////            try{
////                int min1 = arrayMin(data7);
////                System.out.println(min1);
////            } catch (Exception e) {
////                System.out.println("数组没有进行初始化");
////            }
////
////            //8.计算数组之和
////            int[] data8=new int[]{10,4,5,2,1};
////            try{
////                int sum1 = arraySum(data7);
////                System.out.println(sum1);
////            } catch (Exception e) {
////                System.out.println("数组没有进行初始化");
////            }finally {
////                System.out.println("异常处理完毕");
////            }
//
////            //9.数组拼接
////            int[] dataA=new int[]{1,2,3};
////            int[] dataB=new int[]{4,5,6};
////            int[] dataC=joinArray(dataA,dataB);
////            System.out.println(java.util.Arrays.toString(dataC));
//            //10.数组截取
//            int[] data10=new int[]{1,2,3,4,5,6,7,8,9};
//            int[] afterSub=subArray(data10,2,5);
//            System.out.println(java.util.Arrays.toString(afterSub));
//        }
//
//    }




//对象数组：我们的数组放的是相同类型的一组元素；而我们的对象数组里面的每一个元素是一个对象，一个对象里面可以有
//多个属性，这样的话我们这个数组可以存放的内容更加的广泛了。
public class Arraysz{
    private int num;
    private String color;

    public int getNum() {
        return num;
    }

    public String getColor() {
        return color;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Arraysz(int num, String color){
        this.num=num;
        this.color=color;
    }
    public void getInfo(){
        System.out.println( "编号:"+getNum()+",颜色："+getColor());
    }
    public static void main(String[] args) {
//(1)静态初始化
//        Arraysz[] a=new Arraysz[]{
//                new Arraysz(1,"red") ,
//                new Arraysz(2,"white")
//        };//对象数组静态初始化
// (2)动态初始化
        Arraysz[] a=new Arraysz[3];
        a[0]=new Arraysz(1,"red");
        a[1]=new Arraysz(2,"blue");
        a[2]=new Arraysz(3,"black");
        for(int i=0;i<a.length;i++){
            a[i].getInfo();
        }
    }
}