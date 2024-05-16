package org.example.think_10_dp.base;

// 整数拆分
// 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
public class LC_6_343_integerBreak {

    public static int integerBreak(int n) {
        //dp[i] 为正整数 i 拆分后的结果的最大乘积
        int[] dp = new int[n+1];
        dp[2] = 1; // dp[0] = dp[1] =0

        for(int i = 3; i <= n; i++) {
            // j < i  -> j<=i/2(拆近似相同的数)
            for(int j = 1; j < i; j++) {


                // j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
                //而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j])); // 三者的最大值
            }
        }
        return dp[n];
    }

    //for(int j = 1; j <= i-j; j++)
    // 这里的 j 其实最大值为 i-j,再大只不过是重复而已，
    //并且，在本题中，我们分析 dp[0], dp[1]都是无意义的，
    //j 最大到 i-j,就不会用到 dp[0]与dp[1]


    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
