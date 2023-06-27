package org.example.offer_5_mn;

import java.util.Stack;


//剑指 Offer 31. 栈的压入、弹出序列

//输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1


public class Offer_2_31_validateStackSequences {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {

        int [] a = new int[]{1,2,3,4,5};
        int [] b = new int[]{4,5,3,2,1};
        System.out.println(validateStackSequences(a, b));
    }
}
