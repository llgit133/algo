package org.example.think_6_stack_queue;


//有效的括号

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

//有效字符串需满足：
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//注意空字符串可被认为是有效字符串。

import java.util.Deque;
import java.util.LinkedList;

//输入：s = "()[]{}"
//输出：true
public class LC_3_20_isValid {

    public static boolean isValid(String s) {

        Deque<Character> deque = new LinkedList<>();
        char ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {deque.push(')');}
            else if (ch == '{') {deque.push('}');}
            else if (ch == '[') {deque.push(']');}

            else if (deque.isEmpty() || deque.peek() != ch) {return false;}
            //如果是右括号判断是否和栈顶元素匹配
            else {deque.pop();}
        }

        return deque.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("(){}[]"));
    }
}
