package com.wschase.queue;

import java.util.LinkedList;
import java.util.Queue;

/**队列：先进先出
 * 1.入队列：public E add(E item)
 * 2.出队列：public E poll() or public E peek()
 * Author:WSChase
 * Created:2019/1/15
 */
public class TestQueue {
    public static void main(String[] args) {
        Queue<String> queue=new LinkedList<>();

        //1.元素入队列
        //因为是通过LinkedList来实现的，所以添加元素的方法就是LinkedList添加元素的方法
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");

        //2.元素出队列
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        //总共只有4个元素，第五次出队列的时候队列已经为空
        System.out.println(queue.poll());

    }
}
