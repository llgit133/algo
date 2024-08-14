package com.interview;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间
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

    // 学习 2.使用集合Set解决
    // 时间复杂度O（N) 空间复杂度O（N)
    public static int Solution2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                //如果添加失败，说明这个值在集合Set中存在，我们要把他给移除掉
                set.remove(num);
            }
        }

        //注意：这里我们返回的是一个Object类型的数组，需要我们进行强制类型转换
        //最终集合Set中只有一个元素，我们直接返回
        return (int) set.toArray()[0];
    }



    public static void main(String[] args) {

        // 除了某个元素只出现一次以外，其余每个元素均出现两次
        int [] num = {4,1,2,1,2};
        System.out.println(Solution(num));

        System.out.println(Solution2(num));
    }
}
