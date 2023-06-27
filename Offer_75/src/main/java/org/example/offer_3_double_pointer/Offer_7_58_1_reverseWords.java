package org.example.offer_3_double_pointer;

import java.util.Stack;

//剑指 Offer 58 - I. 翻转单词顺序
//输入: "the sky is blue"
//输出: "blue is sky the"

public class Offer_7_58_1_reverseWords {
    public static String reverseWords(String s) {

        s = s.trim();
        String[] myArray = s.split("\\s+");
        String str = "";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < myArray.length; i++) {
            stack.push(myArray[i]);
        }
        while(!stack.empty() ){
            str += " "+stack.pop();
        }
        return str.trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("    the sky is    blue"));
    }
}
