package org.example.think_10_dp.base;


//不同路径
public class LC_4_62_uniquePaths {
    // 由上到下、从左到右
    public static int uniquePaths(int m, int n) {

        // 1、dp
        int [][] dp = new int[m][n];

        //2、初始化
        for (int i = 0; i < m; i++) {dp[i][0] = 1;}
        for (int j = 0; j < n; j++) {dp[0][j] = 1;}

        //3、dp推导
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        //4、返回
        return dp[m-1][n-1];
    }

    // 法二  dfs
    public static int uniquePaths1(int m, int n) {
        return dfs(1, 1, m, n);
    }

    public  static int dfs(int i, int j, int m, int n){
        if (i > m || j > n) return 0; // 越界了
        if (i == m && j == n) return 1; // 找到一种方法，相当于找到了叶子节点
        return dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
    }

    public static void main(String[] args) {

        System.out.println(uniquePaths1(3, 7));
    }
}
