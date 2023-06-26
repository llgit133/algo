package org.example.FirstPage;


//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
public class LC_9_isPalindrome {


    public static boolean isPalindrome(int x) {
        // "121"
        String s = Integer.toString(x);
        String b= "";

        // "121"
        for (int i = s.length() -1; i >= 0 ; i--) {
            b += s.charAt(i);
        }

        return s.equals(b);
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
