package org.example.offer_5_mn;

//剑指 Offer 29. 顺时针打印矩阵
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]

public class Offer_1_29_spiralOrder {

    public static int[] spiralOrder1(int[][] matrix) {
        if (matrix.length == 0) return new int[0];

        // Java 代码利用了 ++ 操作的便利性，详情可见 ++i 和 i++ 的区别 ；
        // res[x++] 等价于先给 res[x] 赋值，再给 x 自增 1 ；

        int l = 0;                       //左边界
        int r = matrix[0].length - 1;    //右边界
        int t = 0;                       //上边界
        int b = matrix.length - 1;       //下边界
        int [] res = new int[(r+1) * (b+1)];
        int x = 0;
        while(true){

            //从左往右
            //列在变，列为循环值
            //从左往右的下一步是往下走，上边界内缩，故++t
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i];
            if(++t > b) break; // ++t > b 等价于先给 t 自增 1，再判断 t > b 逻辑表达式。


            //从上往下，行在变
            //从上往下的下一步是从右往左，右边界收缩，--r
            for(int j = t; j <= b; j++) res[x++] = (matrix[j][r]);
            if(--r < l) break;

            //从右向左，列在变
            //从右往左的下一步是从下往上，下边界收缩，--b
            for(int i = r; i >= l; i--) res[x++] = (matrix[b][i]);
            if(--b < t) break;

            //从下到上，行在变
            //从下到上的下一步是从左到右，左边界收缩，++l
            for(int i = b; i >= t; i--) res[x++] = (matrix[i][l]);
            if(++l > r) break;
        }
        return res;
    }




    public static void main(String[] args) {
        int [][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[] ints = spiralOrder1(matrix);
        for (int anInt : ints) {
            System.out.print(" "+anInt);
        }
    }
}
