package org.example.offer_1_Interger;


/***
 *
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 *
 */

public class offer_1_divide {

    public static int divide(int a, int b) {


        /**
         *          1.减法的方式 -- 目前只实现了正整数的减法
         *          a.刚好减为0
         *          b.最后0<x<b
         *          c.小于0，为负数
         * */
        Integer count = 0;
        int c = a;

        // 1.求余数
        c = c - b;
        while (c >= 0) {
            count++;
            c = c - b;
        }

        // 2.根据余数判断商的情况
        c = c - b;
        return c <= 0 ? count : count + 1;
    }


    public static void main(String[] args) {
        System.out.println(divide(1, 1));


    }
}
