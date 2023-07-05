package org.example.think_4_string;


//剑指Offer58-II.左旋转字符串
//示例 1：
//输入: s = "ab、cdefg", k = 2
//输出: "cdefg、ab"
public class LC_5_Offer_58_2_reverseLeftWords {


    public  static String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();

        for(int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for(int i = 0; i < n; i++)
            res.append(s.charAt(i));

        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }
}

