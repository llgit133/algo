package org.example.offer_10_dp;


//剑指 Offer 48. 最长不含重复字符的子字符串
//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
public class Offer_7_48_lengthOfLongestSubstring {

    //1、滑动窗口，用set维护一个不重复的窗口
    public static int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int res = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // 出现重复了，开始向前删除
            while(set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            res = Math.max(res, right - left + 1);
        }

        return res;
    }

    //TODO

    //2、动态规划  ！11不太理解

    //1、dp[j] 代表以字符 s[j] 为结尾的 “最长不重复子字符串” 的长度。
    //2、dp[j] = dp[j - 1] + 1，当 dp[j - 1] < j - i
    //  dp[j] = j - i，         当 dp[j - 1] ≥ j − i
    //3、
    //4、
    //5、
    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = map.getOrDefault(s.charAt(j), -1); // 获取索引 i
            map.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }


    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
