package org.example.offer_4_stack_queue;

import java.util.Stack;

//剑指 Offer 09. 用两个栈实现队列
//用两个栈实现一个队列。
// 请实现它的两个函数 appendTail 和 deleteHead
// 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )

public class Offer_1_9 {

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(3);

    }
}


class CQueue {

    Stack<Integer> stack;
    Stack<Integer> temp;
    public CQueue() {
        stack = new Stack<>();
        temp = new Stack<>();
    }
    // 输入栈 ：只需要接收 添加到队列尾部的元素;
    public void appendTail(int value) {
        stack.push(value);
    }

    // 输出栈 ：有且仅有在输出栈为空时，才会将弹出输入栈中元素 && 将其加入到输出栈中;
    public int deleteHead() {
        if(temp.isEmpty()){
            // 输入输出栈，都为空
            if(stack.isEmpty()){return -1;}

            // 输入栈中所有元素，全部压栈到输出栈中;
            while(!stack.isEmpty()){temp.push(stack.pop());}
        }
        // 直接返回输出栈的栈顶元素即可;
        return temp.pop();
    }
}