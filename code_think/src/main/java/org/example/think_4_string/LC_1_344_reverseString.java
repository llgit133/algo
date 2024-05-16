package org.example.think_4_string;

//输入：s = "hello"
//输出：["o","l","l","e","h"]
//不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
public class LC_1_344_reverseString {

    public static void reverseString(char[] s) {

        int length = s.length-1;
        // 首尾对换
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[length-i];
            s[length-i] = temp;
        }

        for (char c : s) {
            System.out.print(" "+c);
        }
    }

    public static void main(String[] args) {
        char [] s = new char[]{'h','e','l','l','o'};
        reverseString(s);
    }
}
