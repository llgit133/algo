package com.Solution.lc_01_window;


// hard
//    给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
public class lc_76_minWindow {

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] tCount = new int[256]; // ASCII表大小
        int[] sCount = new int[256]; // 用于滑动窗口内的字符计数

        // 计算t中每个字符出现的次数
        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)]++;
        }

        int left = 0, right = 0;
        int validCount = 0; // 窗口中满足条件的字符数量
        String result = "";

        while (right < s.length()) {
            char c = s.charAt(right);
            sCount[c]++;

            // 如果窗口中的字符在t中出现且数量满足要求，则validCount加1
            if (tCount[c] != 0 && sCount[c] <= tCount[c]) {
                validCount++;
            }

            // 尝试收缩窗口直到validCount大于0
            while (validCount == t.length()) {
                if (result.isEmpty() || (right - left + 1) < result.length()) {
                    result = s.substring(left, right + 1);
                }

                // 移动左边界，尝试缩小窗口
                char leftChar = s.charAt(left);
                sCount[leftChar]--;

                // 如果窗口左边的字符在t中出现，且移除后不满足条件，则validCount减1
                if (tCount[leftChar] != 0 && sCount[leftChar] < tCount[leftChar]) {
                    validCount--;
                }
                left++;
            }
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));

    }
}
