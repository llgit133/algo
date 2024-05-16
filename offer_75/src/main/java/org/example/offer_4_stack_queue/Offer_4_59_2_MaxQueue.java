package org.example.offer_4_stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//剑指 Offer 59 - II. 队列的最大值
//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
//若队列为空，pop_front 和 max_value需要返回 -1

public class Offer_4_59_2_MaxQueue {

    public static void main(String[] args) {

        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(5);
        maxQueue.push_back(1);
        System.out.println(maxQueue.max_value());

        maxQueue.push_back(3);
        maxQueue.pop_front();
        System.out.println(maxQueue.max_value());
        maxQueue.pop_front();
    }
}


class MaxQueue {

    Queue<Integer> queue;  // 单端队列
    Deque<Integer> deque;  // 双端队列

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    // 进队
    public void push_back(int value) {
        queue.offer(value);

        // 维护一个递减的单调双端队列
        while(!deque.isEmpty() && deque.peekLast() < value)
            deque.pollLast();

        deque.offerLast(value);
    }

    // 出队peek获取但不移除队列头部元素 、  poll获取并移除队列头部元素
    public int pop_front() {

        if(queue.isEmpty()) return -1;

        // 相等时双端队列出队
        if(queue.peek().equals(deque.peekFirst()))
            deque.pollFirst();

        // 出队
        return queue.poll();
    }
}
