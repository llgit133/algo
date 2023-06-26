package org.example.think_1_array;


//你正在探访一家农场，农场从左到右种植了一排果树。
// 这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。


//输入：fruits = [1,2,1]
//输出：3
//解释：可以采摘全部 3 棵树。

//输入：fruits = [0,  1,2,2]
//输出：3
//解释：可以采摘 [1,2,2] 这三棵树。
//如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。

//输入：fruits = [1,   2,3,2,2]  输出：4
//输入：fruits = [3,3,3,   1,2,1,1,2,    3,3,4]   输出：5
public class LC_4_904_totalFruit {

    public static int totalFruit(int[] fruits) {

        int left = 0;
        int sum  = 0;

        return 0;

    }



    public static void main(String[] args) {

        int [] nums = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(nums));
    }
}
