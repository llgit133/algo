package org.example.offer_10_dp;



//剑指 Offer 10- I. 斐波那契数列
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
public class Offer_1_10_1_fib {

    public static int fib(int n) {

        if (n == 0 || n == 1) return n;


        int [] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i -1] + dp[i - 2];
        }
        return dp[n-1];
    }


    public static void main(String[] args) {
        System.out.println(fib(2));
    }
}

