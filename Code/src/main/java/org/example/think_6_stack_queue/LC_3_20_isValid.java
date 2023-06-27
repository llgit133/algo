package org.example.think_6_stack_queue;


//有效的括号

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

//有效字符串需满足：
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//注意空字符串可被认为是有效字符串。

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//输入：s = "()[]{}"
//输出：true
public class LC_3_20_isValid {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {stack.push(')');}
            else if (ch == '{') {stack.push('}');}
            else if (ch == '[') {stack.push(']');}

            // 遍历过程中栈为空、或者不等则false
            else if (stack.isEmpty() || stack.peek() != ch) {return false;}

            //如果是右括号判断是否和栈顶元素匹配
            else {stack.pop();}
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("(){}[]"));
    }
}
