package org.example.think_10_dp.base;


//不同的二叉搜索树
public class LC_7_96_numTrees {

    public static int numTrees(int n) {
        //初始化 dp 数组
        int[] dp = new int[n + 1];

        //初始化0个节点和1个节点的情况
        dp[0] = 1;   // 空二叉树也是一种二叉树
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {

                //对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
                //一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j

                dp[i] = dp[i] + dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }
}
