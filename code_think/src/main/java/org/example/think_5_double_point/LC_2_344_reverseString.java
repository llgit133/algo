package org.example.think_5_double_point;

public class LC_2_344_reverseString {

    public static void reverseString(char[] s) {
        int length = s.length-1;
        // 首尾对换
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[length-i];
            s[length-i] = temp;
        }
    }


    public static void main(String[] args) {

    }
}
