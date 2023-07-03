package org.example.think_1_array;


// 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
// 如果不存在符合条件的子数组，返回 0。

// 示例：
// 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2
// 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
public class LC_4_209_minSubArrayLen {

    //所谓滑动窗口，就是不断的调节子序列的起始位置和终止位置，从而得出我们要想的结果。
    //窗口就是 满足其和 ≥ s 的长度最小的连续子数组。
    //窗口的起始位置如何移动：如果当前窗口的值大于s了，窗口就要向前移动了（也就是该缩小了）。
    //窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，也就是for循环里的索引。

    // 滑动窗口
    public static int minSubArrayLen(int s, int[] nums) {

        int sum = 0;
        int left = 0;
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];

            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum = sum -  nums[left];
                left++;
            }
        }

        //如果result没有被赋值的话，就返回0，说明没有符合条件的子序列

        return result == Integer.MAX_VALUE ? 0 : result;
    }


    public static void main(String[] args) {

        int [] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));

    }
}
