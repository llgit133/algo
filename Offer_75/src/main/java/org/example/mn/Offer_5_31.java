package org.example.mn;

import java.util.Stack;

public class Offer_5_31 {

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
