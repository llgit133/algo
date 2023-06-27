package org.example.think_6_stack_queue;



//输入：tokens = ["2","1","+","3","*"]
//输出：9
//解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9


//输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//输出：22
//解释：该算式转化为常见的中缀算术表达式为：
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22

import java.util.Stack;

public class LC_5_150_evalRPN {

    //后缀表达式

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {

            // 遇见操作符的情况
            if ("+".equals(s)) {stack.push(stack.pop() + stack.pop());}
            else if ("-".equals(s)) {stack.push(-stack.pop() + stack.pop());}
            else if ("*".equals(s)) {stack.push(stack.pop() * stack.pop());}

            // 除数不可为0
            else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            }

            // 遇见数字的情况
            else {stack.push(Integer.valueOf(s));}
        }
        return stack.pop();
    }


    public static void main(String[] args) {
       String [] strs = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(strs));
    }
}
