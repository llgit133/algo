package org.example.offer_10_dp;



//剑指 Offer 42. 连续子数组的最大和

//输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
public class Offer_4_42_maxSubArray {



    //1、暴力解法  O(N^2)
    //2、dp      O(N)

    public static int maxSubArray(int[] nums) {

        //1、dp[i]：包括下标i（以nums[i]为结尾）的最大连续子序列和为dp[i]。
        //2、dp[i] = max(dp[i - 1] + nums[i], nums[i]);
        //3、dp[0] = nums[0]
        //4、dp[i]依赖于dp[i - 1]的状态，需要从前向后遍历
        //5、举例推导dp数组

        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);

            // result 保存dp[i]的最大值
            if (dp[i] > res) res = dp[i];
        }

        for (int i : dp) {
            System.out.print(" "+i);
        }

        return res;
    }


    public static void main(String[] args) {

        int [] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
