package com.Solution.lc_01_window;


/***
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * */
public class lc_209_minSubArrayLen {



    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];

            while (sum >= target) {

                // result 上次的最小值
                // right - left + 1 之间的数据个数
                result = Math.min(result, right - left + 1);
                sum = sum -  nums[left];
                left++;
            }
        }

        //如果result没有被赋值的话，就返回0，说明没有符合条件的子序列

        return result == Integer.MAX_VALUE ? 0 : result;
    }



    public static void main(String[] args) {


        int target = 7;
        int [] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums));

    }
}

//https://zhuanlan.zhihu.com/p/676882764





