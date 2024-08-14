package com.interview;


/**
 *
 * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * matrix = [
 * [1,4,7,11,15],
 * [2,5,8,12,19],
 * [3,6,9,16,22],
 * [10,13,14,17,24],
 * [18,21,23,26,30]], target = 5
 *
 * */
public class lc_03_searchMatrix {

    public static boolean Solution(int [][] matrix,int target){


        // 1.从左上角开始搜索(0,0) 或者从右下角开始搜索(4,4)
        // (0,0)比target大的元素在右和下 就无法定位向下走还是右走



        // 2.从矩阵右上角开始搜索(0,4)
        // 比target大的元素向左走col--,比target小的元素在下面走row--
        int col = matrix[0].length - 1;//列
        int row = 0;//行

        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
               col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }


        // 3.从矩阵左下角开始搜索（4,0）
        // target小向上，大向右
        int col3 = 0;//列
        int row3= matrix[0].length - 1;//行
        while (col3 <= matrix.length - 1 && row3 >= 0){

            if(matrix[row3][col3] == target) return true;
            else if(matrix[row3][col3] < target)  col3++;
            else if (matrix[row3][col3] > target) row3--;
        }
        return false;
    }




    public static void main(String[] args) {

        int[][] matrix = {
                {1,  4,  7,  11, 15},
                {2,  5,  8,  12, 19},
                {3,  6,  9,  16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(Solution(matrix, 35));

    }
}
