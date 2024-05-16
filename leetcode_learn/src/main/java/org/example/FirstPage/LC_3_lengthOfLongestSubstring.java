package org.example.FirstPage;


//3. 无重复字符的最长子串
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。


import java.util.HashSet;
import java.util.Set;

// hash +双指针
public class LC_3_lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {

        int ans = 0;
        Set<Character> hashSet = new HashSet<>();

        int l = 0;
        for (int i = 0; i < s.length(); i++) {

            if(hashSet.contains(s.charAt(i)) == false){ hashSet.add(s.charAt(i));}
            else {
                hashSet.remove(s.charAt(i));
                l++;
            }
            ans = hashSet.size();
            ans = Math.max(ans,i-l+1);
        }
        return ans;
    }


    public static int lengthOfLongestSubstring1(String s) {
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


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
    }
}


