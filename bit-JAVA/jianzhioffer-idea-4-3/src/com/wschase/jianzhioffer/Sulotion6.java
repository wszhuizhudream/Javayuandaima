package com.wschase.jianzhioffer;

/**
 * Author:WSChase
 * Created:2019/4/3
 */

import org.w3c.dom.css.Rect;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Sulotion6 {
    public int RectCover(int target) {

        if(target<=0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        //（1）其实质就是斐波那契数---但是使用这个方法需要的时间更长运用斐波那契数求解会多次重复计算
        //int result=RectCover(target-1)+RectCover(target-2);
        //（2）使用下面的方法需要花费的时间更少
            int one=1;
            int two=2;
            int result=0;
            for(int i=2;i<target;i++) {
                result = one + two;
                one = two;
                two = result;
            }
                return result;
    }
}
