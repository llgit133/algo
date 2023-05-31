package org.example.easy.FirstPage;

import java.util.*;

//有效的括号

// 如果 c 是左括号，则入栈 push；
// 否则通过哈希表判断括号对应关系，若 stack 栈顶出栈括号 stack.pop() 与当前遍历括号 c 不对应，则提前返回 false。
public class leetcode_20 {

    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        // key 是左括号  value是右括号
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {return false;}
                stack.pop();
            }
            else {stack.push(ch);}
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(isValid("({})"));
    }
}
