package org.example.FirstPage;


//给你一个字符串 s，找到 s 中最长的回文子串。
//如果字符串的反序与原始字符串相同，则该字符串称为回文字符串

//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
public class LC_5_longestPalindrome {


    //1、扩展中心
    //我们知道回文串一定是对称的，所以我们可以每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可。
    public static String longestPalindrome(String s) {

        for (int i = 1; i < s.length() -1; i++) {
            int left =  i -1 , right = i + 1;

            if (s.charAt(left) == s.charAt(right) && left > 0 && right <= s.length() - 1){
                left --;
                right ++;
                String str = s.substring(left, right + 1);
                System.out.println(str);
            }
            else System.out.println(s.charAt(i));
        }
        return null;
    }


    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }



    //从每一个位置出发，向两边扩散即可。遇到不是回文的时候结束
    //首先往左寻找与当期位置相同的字符，直到遇到不相等为止。
    //然后往右寻找与当期位置相同的字符，直到遇到不相等为止。

    public static String longestPalindrome3(String s) {
        if(s.length() == 0 || s == null) {return "";}

        int strLen = s.length();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int maxStart = 0;
        char[] charArray = s.toCharArray();

        for(int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            int len = 1;

            // b、b
            while(left >= 0 && charArray[left] == charArray[i]) {
                left--;
                len++;
            }

            // a、a
            while(right < strLen && charArray[right] == charArray[i]) {
                right++;
                len++;
            }

            // a、b 、a
            while(left >= 0 && right < strLen && charArray[left] == charArray[right]) {
                left--;
                right++;
                len += 2;
            }

            //每个位置向两边扩散都会出现一个窗口大小（len）。如果 len>maxLen(用来表示最长回文串的长度）。则更新 maxLen 的值。
            //因为我们最后要返回的是具体子串，而不是长度，因此，还需要记录一下 maxLen 时的起始位置（maxStart），即此时还要 maxStart=len。
            if(len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
        }
        // 妙啊
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }


    public static void main(String[] args) {

        System.out.println(longestPalindrome3("babad"));
    }
}
