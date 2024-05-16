package org.example.offer_1_string;


//剑指 Offer 58 - II. 左旋转字符串

//输入: s = "abcdefg", k = 2
//输出:"cdefgab"

//输入: s = "lrloseumgh", k = 6
//输出:"umghlrlose"
public class Offer_2_58_2_reverseLeftWords {

    // 1. 字符串拼接
    public static String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();

        for(int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for(int i = 0; i < n; i++)
            res.append(s.charAt(i));

        return res.toString();
    }

    // 2.Java api substring
    public static String reverseLeftWords2(String str, int n) {
        String str1 = str;
        return str.substring(n,str.length()) + str1.substring(0,n);
    }



    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
        System.out.println(reverseLeftWords2("abcdefg",2));
    }
}
