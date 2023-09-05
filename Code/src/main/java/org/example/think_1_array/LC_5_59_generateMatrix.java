package org.example.think_1_array;


//59.螺旋矩阵II
//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//输入：n = 3
//输出：
// [1,2,3],
// [8,9,4],
// [7,6,5]
public class LC_5_59_generateMatrix {

    //本题并不涉及到什么算法，就是模拟过程，但却十分考察对代码的掌控能力。
    //模拟顺时针画矩阵的过程:
    //填充上行从左到右
    //填充右列从上到下
    //填充下行从右到左
    //填充左列从下到上



    //[)
    public static int[][] generateMatrix(int n) {
        int loop = 0;  // 控制循环次数
        int[][] res = new int[n][n];
        int start = 0;  // 每次循环的开始点(start, start)
        int count = 1;  // 定义填充数字
        int i, j;


        // 0-n-1    1-n-2    3-n-3
        while (loop++ < n / 2) { // 判断边界后，loop从1开始

            // 模拟上侧 从左到右（不包括最右）
            for (j = start; j < n - loop; j++) {res[start][j] = count++;}

            // 模拟右侧 从上到下
            for (i = start; i < n - loop; i++) {res[i][j] = count++;}

            // 模拟下侧从右到左
            for (; j >= loop; j--) {res[i][j] = count++;}

            // 模拟左侧从下到上
            for (; i >= loop; i--) {res[i][j] = count++;}

            // 下一轮开始
            start ++;
        }

        // 最后一圈只有一个奇数的时候
        if (n % 2 == 1) {res[start][start] = count;}
        return res;
    }


    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);

        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(" "+i);
            }
            System.out.println();
        }

    }
}
