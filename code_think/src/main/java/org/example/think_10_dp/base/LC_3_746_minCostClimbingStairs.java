package org.example.think_10_dp.base;

// 使用最小花费爬楼梯
public class LC_3_746_minCostClimbingStairs {


    //dp[i - 1] 跳到 dp[i] 需要花费 dp[i - 1] + cost[i - 1]
    //dp[i - 2] 跳到 dp[i] 需要花费 dp[i - 2] + cost[i - 2]
    public static int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[ cost.length+1 ];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= cost.length; i++) {
            dp[i]  = Math.min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2]);
        }
        return dp[dp.length-1];
    }


    public static void main(String[] args) {

        int [] nums = new int[]{1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(nums));
    }
}
