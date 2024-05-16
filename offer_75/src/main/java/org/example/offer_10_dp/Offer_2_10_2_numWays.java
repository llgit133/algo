package org.example.offer_10_dp;


//剑指 Offer 10- II. 青蛙跳台阶问题
//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
public class Offer_2_10_2_numWays {

    public static int numWays(int n) {

        if(n <= 1) return 1;

        int [] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i -2])%1000000007;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
}
