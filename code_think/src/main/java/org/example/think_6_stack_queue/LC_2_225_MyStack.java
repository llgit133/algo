package org.example.think_6_stack_queue;


///使用队列实现栈的下列操作：

import java.util.LinkedList;
import java.util.Queue;

//push(x) -- 元素 x 入栈
//pop() -- 移除栈顶元素
//top() -- 获取栈顶元素
//empty() -- 返回栈是否为空
public class LC_2_225_MyStack {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

    }
}


// 用两个队列que1和que2实现队列的功能，
// que2其实完全就是一个备份的作用，把que1最后面的元素以外的元素都备份到que2，
// 然后弹出最后面的元素，再把其他元素从que2导回que1。
class MyStack {

    Queue<Integer> queue1; // 和栈中保持一样元素的队列
    Queue<Integer> queue2; // 辅助队列


    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }


    public void push(int x) {
        queue2.offer(x); // 先放在辅助队列中
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }

        // 最后交换queue1和queue2，将元素都放到queue1中
        Queue<Integer> queueTemp;
        queueTemp = queue1;
        queue1 = queue2;
        queue2 = queueTemp;
    }

    public int pop() {
        return queue1.poll(); // 因为queue1中的元素和栈中的保持一致，所以这个和下面两个的操作只看queue1即可
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}