package org.example.think_4_string;


//151.翻转字符串里的单词

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//输入: "the sky is blue"
//输出: "blue is sky the"
public class Lc_4_151_reverseWords {

    public static String reverseWords(String s) {
        s = s.trim();
        // String[] str =  s.split("\\s+",-1);

        // 字符数组转为list   Arrays.aslist(a[])
        List<String> list = Arrays.asList(s.split("\\s+", -1));
        Collections.reverse(list);


        // join 方法  join数组
        return String.join(" ", list);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
