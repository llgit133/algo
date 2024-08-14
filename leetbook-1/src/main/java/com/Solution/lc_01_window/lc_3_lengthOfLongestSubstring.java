package com.Solution.lc_01_window;

import java.util.HashSet;
import java.util.Set;

public class lc_3_lengthOfLongestSubstring {


    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            // 出现重复了，开始向前删除
            while(set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(c);
            res = Math.max(res, r - l + 1);
        }

        return res;
    }


    public static int lengthOfLongestSubstring1(String s) {
        int left = 0; // 窗口的左边界
        int maxLength = 0; // 最长不重复子串的长度
        int[] charIndexMap = new int[128]; // 假设字符集大小为128，用于存储字符的索引

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            // 如果字符已经出现过，移动left指针到重复字符的下一个位置
            if (charIndexMap[currentChar] != -1) {
                // left
                // charIndexMap[currentChar] + 1
                left = Math.max(left, charIndexMap[currentChar] + 1);
            }
            // 更新字符的索引
            charIndexMap[currentChar] = right;
            // 更新最长子串的长度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring1("abcabcbb"));


    }
}
