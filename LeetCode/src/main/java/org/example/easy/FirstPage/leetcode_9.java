package org.example.easy.FirstPage;

public class leetcode_9 {

    public static boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        String b= "";
        for (int i = s.length() -1; i >= 0 ; i--) {
            b += s.charAt(i);
        }
        return s.equals(b);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
}

