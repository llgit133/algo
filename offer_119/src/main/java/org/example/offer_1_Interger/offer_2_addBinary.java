package org.example.offer_1_Interger;


/**
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * */
public class offer_2_addBinary {


    /**
     * 1.二进制转为十进制
     * 2.十进制相加
     * 3.十进制转为二进制
     *
     * */
    public static String addBinary(String a, String b) {

        String res = null;
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < a.length(); i++) {
            sum1 = (int) (sum1 +  Math.pow(2, a.length() - i - 1) * (a.charAt(i) - '0') ) ;
        }


        for (int i = 0; i < b.length(); i++) {
            sum2 = (int) (sum2 +  Math.pow(2, b.length() - i - 1) * (a.charAt(i) - '0') ) ;
        }
        System.out.println(sum1);
        System.out.println(sum1 + sum2);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
