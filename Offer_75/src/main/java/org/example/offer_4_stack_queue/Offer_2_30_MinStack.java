package org.example.offer_4_stack_queue;

import java.util.Stack;

//剑指 Offer 30. 包含min函数的栈
//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.

public class Offer_2_30_MinStack {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        minStack.min();
        minStack.pop();
        minStack.top();
        minStack.min();
    }
}
class MinStack {

    Stack<Integer> stack;
    Stack<Integer> temp;

    public MinStack() {
        this.stack = new Stack<>();
        this.temp = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        int min = temp.isEmpty() ? x : Math.min(temp.peek(), x);
        temp.push(min);
    }

    public void pop() {
        stack.pop();
        temp.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return temp.peek();
    }
}