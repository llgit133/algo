package com.interview;


import java.util.ArrayList;
import java.util.Collections;

/**
 *
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 *
 * **/
public class lc_04_merge {


    public static ArrayList<Integer> Solution(int [] nums1,int m, int [] nums2,int n){

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0;i< m;i++){
            list.add(nums1[i]);
        }

        for(int j = 0;j < n;j++){
            list.add(nums2[j]);
        }
        // 快排而且是稳定性的排序
        Collections.sort(list);
        return list;

    }


    public static void main(String[] args) {

        int [] a = {1,2,3,0,0,0};
        int [] b = {2,5,6};
        System.out.println(Solution(a,3,b,3));
    }
}
