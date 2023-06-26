package org.example.offer_10_dp;


//剑指 Offer 48. 最长不含重复字符的子字符串
//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
public class Offer_7_48 {


    // 有问题：
    public static int lengthOfLongestSubstring(String s) {

        int length = 0;

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i)) == false) set.add(s.charAt(i));
            else {
                int temp = set.size();
                length= Math.max(length,temp);
                set.clear();
                set.add(s.charAt(i));
            }
        }
        return length;

    }


    //滑动窗口，用set维护一个不重复的窗口
    public static int lengthOfLongestSubstring1(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            // 出现重复了，开始向前删除
            while(set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            res = Math.max(res, r - l + 1);
        }

        return res;
    }


    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring1(""));
    }
}
