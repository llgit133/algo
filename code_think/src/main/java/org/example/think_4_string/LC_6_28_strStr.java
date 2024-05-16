package org.example.think_4_string;


//28. 找出字符串中第一个匹配项的下标  KMP

//示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
//示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1

public class LC_6_28_strStr {


    //前缀表（不减一）Java实现
    // A 主串，B子串
    public static int strStr(String A, String B) {
        if (B.length() == 0) return 0;
        int[] next = new int[B.length()];

        // 求next数组
        getNext(next, B);

        //进行匹配
        int j = 0;
        for (int i = 0; i < A.length(); i++) {
            while (j > 0 && B.charAt(j) != A.charAt(i))
                j = next[j - 1];
            if (B.charAt(j) == A.charAt(i))
                j++;
            if (j == B.length())
                return i - B.length() + 1;
        }
        return -1;

    }

    private static void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }
    }


    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }

}
