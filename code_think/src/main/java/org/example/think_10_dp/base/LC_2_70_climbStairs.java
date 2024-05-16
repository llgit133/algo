package org.example.think_10_dp.base;

//爬楼梯
//此时大家应该发现了，这不就是斐波那契数列么！
public class LC_2_70_climbStairs {
    public static int climbStairs(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }


    //不考虑dp[0]如何初始化，只初始化dp[1] = 1，dp[2] = 2，然后从i = 3开始递推，这样才符合dp[i]的定义。
    public static int climbStairs1(int n) {
        if (n <= 1) return n;
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[2];
    }

    public static int climbStairs2(int n) {
        if(n <= 1) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+ dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs1(3));
        System.out.println(climbStairs2(3));
    }
}
