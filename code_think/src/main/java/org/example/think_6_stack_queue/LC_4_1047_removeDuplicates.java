package org.example.think_6_stack_queue;


//1047. 删除字符串中的所有相邻重复项


//输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
// 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。

import java.util.Stack;

public class LC_4_1047_removeDuplicates {

    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            // 压栈
            if (stack.isEmpty() || stack.peek() != ch) {stack.push(ch);}

            // 出栈、消除
            else {stack.pop();}
        }

        StringBuilder builder = new StringBuilder();
        //剩余的元素即为不重复的元素
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(removeDuplicates("abbaca"));
    }
}
