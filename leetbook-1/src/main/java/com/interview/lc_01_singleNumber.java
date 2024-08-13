package com.interview;



/**
 *
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间
 *
 *
 * */
public class lc_01_singleNumber {



    // 1.位运算抑或  相同得0 不同得1
    // 时间复杂度O（N) 空间复杂度O（1)
    public static int Solution(int [] a){

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result ^= a[i];
        }
        return result;
    }





    public static void main(String[] args) {

        int [] num = {4,1,2,1,2};
        System.out.println(Solution(num));
    }
}
