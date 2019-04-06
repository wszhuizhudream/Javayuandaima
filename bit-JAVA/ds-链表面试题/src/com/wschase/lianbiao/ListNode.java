package com.wschase.lianbiao;


import java.sql.SQLOutput;
import java.util.List;

/**链表面试题
 * Author:WSChase
 * Created:2019/4/5
 */

//首先我们定义一个类，这个类表示结点
 public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 在做题之前我们先复习一下链表的头插、尾插，者两个操作在我们的链表中非常的重要
 * 只有我们可以掌握这两个操作那么链表的题目才可以实现。
 */
class Solution2{
    //定义一个第一个       节点
    private ListNode head;

    //头插
    public void pushFront(int item){
        ListNode node=new ListNode(item);
        if(this.head==null){
            this.head=node;
        }else {
            //首先将这个元素转化为我们的节点
            node.next=this.head;
            this.head=node;
        }
    }

    //尾插
    public void pushBack(int item){
        //尾插最重要的就是要找到最后一个节点，我们此时可以用一个节点来表示最后一个节点，每次做更新
        ListNode node=new ListNode(item);
        if(this.head==null){
            this.head=node;
        }else {
            ListNode last=getLastNode();
            last.next=node;
        }

    }
    //找到最后一个结点
    private ListNode getLastNode() {
        ListNode cur=this.head;
        while(cur.next!=null){
            cur=cur.next;
        }
        return cur;
    }

    //如何通过循环遍历链表内的一个结点--展示一个链表
    public void display(){
        ListNode cur=this.head;
        while (cur!=null){
            System.out.print(cur.val+"--->");
            cur=cur.next;
        }
    }

    //链表的测试
    public static void main(String[] args) {
       Solution2 s=new Solution2();
       //下面进行插入或者删除
    }

}

/**
 * 下面开始讲解我们的链表面试题
 */
class Solution1 {

    /**
     *1.删除链表中等于给定值 val 的所有节点。--[重要]
     * 示例:
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     */

    /**
     * 方法1：
     * 分析：解决这个问题我们有两个方法,第一个是遍历链表中的所有节点，如果节点的val不是要删除的val
     * 就把这个节点尾插到新的链表上。
     */
//    public ListNode removeElements(ListNode head, int val) {
//        //首先定义一个新的结果链表
//        ListNode result=null;
//        //记录result的最后一个节点
//        ListNode last=null;
//        //记录当前链表的第一个节点
//        ListNode node=head;
//        while(node!=null){
//            //定义一个下一个节点
//            ListNode next=node.next;
//            if(node.val!=val){
//                //如果链表中的这个值不等于传进来的这个值那么就将它尾插进结果链表里面
//                if(result==null){
//                    //直接同时给结果链表的第一个节点和最后一个节点进行更行操作
//                    result=last=node;
//                }else {
//                    //如果元素不为空我们将进行尾插操作:并且同时记录最后一个节点的位置
//                    //这样可以减小我们的时间复杂度，因为记录了最后一个节点以后就不需要我们再去遍历了
//                    last.next=node;
//                    last=node;
//                }
//            }else {
//                //另外一种情况是如果当前节点的值等于我们传入的值那么就不管这个节点
//                //本来是需要删除链表的，但是在java里面我们不需要考虑这个问题，因为
//                //JVM会自动的回收我们的垃圾空间。
//            }
//
//            //上面是进行了我们的第一次循环，经过第一次循环以后我们需要对当前节点进行更新操作
//            node=next;
//        }
//
//        //经过上面的遍历以后我们的这个结果链表就是满足条件的链表，我们需要将最后一个节点的下一个节点置为空
//        if(last!=null){
//            last.next=null;
//        }
//        //返回下一个结果链表的第一个节点就是我们的结果链表
//        return result;
//
//    }
//


    /**
     * 方法2：
     * 分析：我们通过给链表设置一个前驱节点、设置一个后继节点，然后遍历链表，如果当前节点的val和
     * val相等，就删除我们的当前节点，最后返回head就是我们的目标链表。
     */
//    public ListNode removeElements(ListNode head, int val) {
//        if(head==null){
//            return null;
//        }else {
//            //定义一个节点的前驱后继
//            ListNode cur=head;
//            ListNode prev=null;
//            ListNode next=cur.next;
//            while(cur!=null){
//                if(cur.val==val){
//                    cur=next;
//                    prev.next=cur;
//                    if(next!=null){
//                        next=next.next;
//                    }
//                }
//                //如果值不相等就往后走
//                cur=next;
//            }
//            //从始至终我们都没有改变这个链表的第一个节点，所以我们返回它以后通过它可以找到我们的整个链表
//            return head;
//        }
//    }

/**
 * 方法3：
 *
 */
//public ListNode removeElements(ListNode head, int val) {
//    if(head==null){
//        return null;
//    }
//    ListNode cur=head;
//    while(cur.next!=null){
//        if(cur.next.val==val){
//
//            //直接将当前结点的下一个结点指向值相等的下一个结点
//            ListNode next=cur.next;
//            cur.next=next.next;
//        }
//    }
//    if(cur.val==val){
//      ListNode second=cur.next;
//      return second;
//    }else {
//        return cur;
//    }
//}
//}

    /**
     *2.反转一个单链表。（一般就是说逆置单链表）--【重要】
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */
    /**
     * 方法1：
     * 我们重新创建一个链表，对原来的链表进行遍历并且将元素头插进新链表中
     */
//    public ListNode reverse(ListNode head) {
//        if (head == null) {
//            return null;
//        } else {
//            //注意：我们一般不用链表的给定结点去操作，都是重新定义结点及逆行操作
//            ListNode cur = head;
//            //我们定义一个结果链表
//            ListNode result = null;
//            while (cur != null) {
//                ListNode next = cur.next;
//                cur.next = result;
//                result = cur;
//                cur = next;
//            }
//            return result;
//        }
//
//    }
    /**
     * 方法2：
     * 分析：我们采用就地逆置的方法将链表进行逆置：此时我们需要定义前驱结点、后继结点
     */
//    public ListNode reverse(ListNode head) {
//        if(head==null){
//            return null;
//        }else {
//            ListNode cur=head;
//            ListNode prev=null;
//            ListNode next=cur.next;
//            while (cur!=null){
//                cur.next=prev;
//                prev=cur;
//                cur=next;
//                if(next!=null){
//                    //因为最后next为空了以后再对它进行引用就会报空指针异常
//                    next=next.next;
//                }
//            }
//
//            //走到最后cur也为null，所以我们只能返回prev
//            return prev;
//        }
//    }

    /**
     * 3.合并两个有序链表
     * 示例：
     * 输入：1->2->4,1->3->4
     * 输出：1->2->3->4->4
     * 注意：左右两个链表不一定是等长的
     */
//    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
//        if(l1==null){
//            return l2;
//        }
//        if(l2==null){
//            return l1;
//        }
//        ListNode cur1=l1;
//        ListNode cur2=l2;
//        ListNode result=null;
//        //记录结果链表的最后一个结点
//        ListNode last=null;
//        while(cur1!=null&&cur2!=null){
//
//            if(cur1.val<=cur2.val){
//                //这个时候就将l1的值尾插进result链表里面
//                if(result==null){
//                    result=last=cur1;
//                }else {
//                    last.next=cur1;
//                    last=cur1;
//                }
//                cur1=cur1.next;
//            }else {
//                if(result==null){
//                    result=last=cur2;
//                }else {
//                    last.next=cur2;
//                    last=cur2;
//                }
//                cur2=cur2.next;
//            }
//
//        }
//        //下面还剩下一种情况需要处理：
//        //一个链表被取空了，还剩下一个链表
//        if(cur1!=null){
//            last.next=cur1;
//        }
//        if(cur2!=null){
//            last.next=cur2;
//        }
//
//        return result;
//    }
//}

/**
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的
 * 结点之前给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
 * 注意：分割以后保持原来的数据顺序不变。
 * 示例：
 * 3->9->1->7->5->4->2     x=5
 * 分为：3->1->4->2       9->7->5
 * 分析：我们一边遍历原来的链表一边将小于和大于的值分别放进两个链表中
  */
//    public ListNode partition(ListNode pHead, int x) {
//        //这个链表是存储大于x的值
//        ListNode small = null;
//        //定义一个结点记录small链表的最后结点
//        ListNode smallLast = null;
//        //这个链表是存储小于x的值
//        ListNode big = null;
//        //定义一个结点记录big链表的最后一个结点
//        ListNode bigLast = null;
//        ListNode cur = pHead;
//
//        while (cur != null) {
//            ListNode next = cur.next;
//            //注意：这句话只能放在循环外面，不可以放在里面
//                cur.next=null;
//            if (cur.val < x) {
//                //对small链表进行尾插
//                if (small == null) {
//                    small = smallLast = cur;
//                } else {
//                    smallLast.next = cur;
//                    smallLast = cur;
//                }
//            } else {
//                //这个表示cur.val>=x的结点，将这个结点尾插到big链表里面
//                if (big == null) {
//                    big = bigLast = cur;
//                } else {
//                    bigLast.next = cur;
//                    bigLast = cur;
//                }
//            }
//            cur = next;
//        }
//
//        //下面将进行链表的拼接：拼接链表的时候我们需要注意有可能为空的链表
//        if(small==null){
//        return big;
//        }
//        else {
//             //经过我们的重新排序以后需要将两个链表合并到一起
//             //将big的第一个结点尾插到small链表里面，就将两个链表链接到一起了
//            ListNode head=small;
//            smallLast.next=big;
//            return head;
//        }
//    }

    /**
     * 5.给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     *
     * 示例 1：
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     * 示例 2：
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
      */
    /**
     * 方法1：首先我们考虑简单的用法，就是遍历链表，记录链表的元素个数
     * 然后将元素的个数除2得到的这个序号对应链表的元素就是我们需要找到的
     * 中间元素这个方法不管是对于奇数个元素还是偶数个元素都是成立的。
     * 【有问题】
     */
//    public ListNode middleNode(ListNode head) {
//        //首先我们需要考虑可能链表为空
//        if(head==null&&head.next==null){
//            return head;
//        }
//
//        //首先我们定义链表的第一个结点
//        ListNode cur=head;
//        //定义一个数用于计数链表里面有几个元素
//        int sum=0;
//        while (cur!=null){
//            cur=cur.next;
//            sum++;
//        }
//        int num=sum/2;
//        ListNode node=head;
//        for(int i=0;i<num;i++){
//            node=node.next;
//        }
//        return node;
//
//    }

    /**
     * 方法2：我们采用快慢引用的方法
     * 通过快慢链表，当一个走到最后的时候另外一个正好走到我们需要的中间位置
     * fast  slow
     */
//    public ListNode middleNode(ListNode head) {
//        ListNode fast=head;
//        ListNode slow=head;
//        while (fast!=null){
//            fast=fast.next;
//            if(fast==null){
//                break;
//            }else {
//                slow=slow.next;
//                fast=fast.next;
//            }
//        }
//        return slow;
//    }


    /**
     * 6.输入一个链表，输出该链表中倒数第k个结点。
     */
    /**
     * 方法1：
     * 分析：本题我们还是采用快慢链表的方式进行遍历，但是这个和找中间结点不同的是，
     *我们需要找到倒数第k个结点，那么我们的fast首先要先走(k-1)步，然后slow和fast再一起走
     *最后当fast等于null的时候，我们的slow对应的结点就是链表中的倒数第k个结点。
     * @param head
     * @param k
     * @return
     * 【有问题】
     */
//    public ListNode FindKthToTail(ListNode head,int k) {
//        if(k<=0){
//            return null;
//        }
//        ListNode fast=head;
//        ListNode slow=head;
//            //我们先让fast走k-1步
//            int i;
//            for( i=0;i<k-1;i++){
//                //走一步判断一步p2知否已经为null了
//                //还有一种情况就是链表的长度小于我们需要找到的倒数第k个结点
//                if(fast==null){
//                    return null;
//                }
//                fast=fast.next;
//            }
//            //等到走完以后还需要判断该链表是否为null
//        if(fast==null){
//            return null;
//        }
//                //接下来fast和slow一起走:但是我们还是需要判断快的链表是否已经走到空的位置
//                while(fast!=null){
//                    fast=fast.next;
//                    if(fast==null){
//                        break;
//                    }
//                    slow=slow.next;
//
//            }
//        return slow;
//
//    }

    /**
     * 方法2：
     * 直接通过计数的方式进行统计倒数第k个结点和前面求解中间结点的方法是一样的
     * @param head
     * @param k
     * @return
     */
//    public ListNode FindKthToTail(ListNode head,int k) {
//
//        ListNode cur=head;
//        int count=0;
//        while (cur!=null){
//        count++;
//        cur=cur.next;
//        }
//        if(count<k){
//            return null;
//        }
//        ListNode node=head;
//        for(int i=0;i<count-k;i++){
//            node=node.next;
//        }
//        return node;
//    }

    /**
     * 7.对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
     * 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
     * 测试样例：
     * 1->2->2->1
     * 返回：true
     */
    /**
     * 只要我们没有双重循环，多个循环只是在O(n)前面乘了系数，但是时间复杂度并不会变
     * 分析：这道题的思路最重要的就是先理解什么是回文，就是从前往后和从后往前走的结构都是一样的
     * 其次，在不能开辟空间的情况下，我们首先找到中间结点，然后从中间结点开始往后将链表进行逆置（逆置一半的链表）
     * 链表逆置以后，通过两个链表进行值的比较，如果出现了不相等那么就不是回文。
     * 注意：对于回文的判断最重要的是会逆置链表，而逆置链表最重要的是会链表的头插
     * @param A
     * @return
     */
//    public boolean chkPalindrome(ListNode A) {
//        //首先找到中间结点
//        ListNode head=A;
//        ListNode cur=head;
//        int count=0;
//        while (cur!=null){
//            count++;
//            cur=cur.next;
//        }
//        ListNode middle=head;
//        for(int i=0;i<count/2;i++){
//            middle=middle.next;
//        }
//        //拿到中间结点以后，下面需要进行后半部分链表的逆置
//        ListNode node=middle;
//        ListNode rhead=null;
//        while (node!=null){
//            ListNode next=node.next;
//            //这个就是在做头插
//            node.next=rhead;
//            rhead=node;
//            //更新需要插入结点的位置
//            node=next;
//        }
//
//        //当链表逆置以后我们需要将两把部分的链表的值进行比较
//        ListNode p1=head;
//        ListNode p2=rhead;
//        //判断是否是回文结构
//        while (p1!=null&&p2!=null){
//            if(p1.val!=p2.val){
//                return false;
//            }
//            p1=p1.next;
//            p2=p2.next;
//        }
//        //当它们跳出循环以后说明走到链表结束它们的值都是相等的
//        return true;
//
//    }

    /**
     * 8.在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */
//    public ListNode deleteDuplication(ListNode pHead)
//    {
//
//        if(pHead!=null){
//            //这个结点是链表第一个结点的假前驱结点——目的是要通过它找到我们链表的第一个结点
//            ListNode fake=new ListNode(0);
//            fake.next=pHead;
//            ListNode prev=fake;
//            ListNode p1=pHead;
//            ListNode p2=pHead.next;
//            while(p2!=null){
//                if(p1.val!=p2.val){
//                    prev=p1;
//                    p1=p2;
//                    p2=p2.next;
//                }else{
//
//                    while(p2!=null&&p1.val==p2.val){
//                        p2=p2.next;
//                    }
//                    prev.next=p2;
//                    p1=p2;
//                    if(p2!=null){
//                        p2=p2.next;
//                    }
//
//                }
//
//            }
//            pHead=fake.next;
//            return pHead;
//        }else {
//            return null;
//        }
//    }
}
















