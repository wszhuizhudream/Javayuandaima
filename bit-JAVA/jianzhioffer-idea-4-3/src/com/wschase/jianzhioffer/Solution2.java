package com.wschase.jianzhioffer;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;

/**输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * Author:WSChase
 * Created:2019/4/3
 */

class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
             this.val = val;
         }
     }
public class Solution2 {
    ArrayList<Integer> arrayList=new ArrayList<>();
    //对于链表我们只是传入了一个节点，但是这个节点就是可以让我们拿到整个链表，他就是第一个节点
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
   if(listNode!=null){
       this.printListFromTailToHead(listNode.next);
           arrayList.add(listNode.val);
   }
       return arrayList;
    }

}
