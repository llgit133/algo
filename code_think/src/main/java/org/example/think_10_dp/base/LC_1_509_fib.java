package org.example.think_10_dp.base;

// 斐波那契数
public class LC_1_509_fib {

    public static int fib(int n) {
        if(n < 0||n > 30) return -1;
        if( n == 0) return 0;
        if( n == 1) return 1;
        return fib(n-1)+fib(n-2);
    }

    public  static int fib1(int n) {
        if (n <= 1) return n;
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public  static int fib2(int n) {
        if (n <= 1) return n;
        int [] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        //我们只需要维护两个数值就可以了，不需要记录整个序列
        for (int i = 2; i <= n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }


    public static void main(String[] args) {

        System.out.println(fib(32));
        System.out.println(fib1(4));
        System.out.println(fib2(4));
    }

}
