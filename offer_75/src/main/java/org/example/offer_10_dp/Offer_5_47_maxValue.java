package org.example.offer_10_dp;


// 礼物的最大价值
// 从棋盘的左上角开始拿格子里的礼物，并每次 向右 或者 向下 移动一格、直到到达棋盘的右下角。
public class Offer_5_47_maxValue {

    // 直接在原数组作为dp、修改
    public static int maxValue(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        // 初始化第一行
        for(int j = 1; j < n; j++)
            grid[0][j] += grid[0][j - 1];

        // 初始化第一列
        for(int i = 1; i < m; i++)
            grid[i][0] += grid[i - 1][0];

        //  行列初始化
        //  {1,4,5},
        //  {2,5,1},
        //  {6,2,1}

        // 其他元素的问题
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                // 上、右 中的最大值
                grid[i][j] = grid[i][j] + Math.max(grid[i][j - 1], grid[i - 1][j]);

        // 取出最后一个元素的值
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {

        int [][] nums = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(maxValue(nums));
    }

}
