package com.week2023down.week_01_skill;

import java.util.*;

/**
 *
 * 2799. 统计完全子数组的数目
 *
 *
 * 输入：nums = [1,3,1,2,2]
 * 输出：4
 * 解释：完全子数组有：[1,3,1,2]、[1,3,1,2,2]、[3,1,2] 和 [3,1,2,2] 。
 *
 *
 * */

public class lc_01_2799_countCompleteSubarrays {



    // 1. 暴力法
    // 双层for循环（获取所有的数组） + set hash(保证元素总数)

    public static int Solution(int[] nums) {

        // 数组转set
        HashSet<Object> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        Integer Setsize = set.size();

        // 优化 获取数组的distinct元素

        // 收集所有的数组list
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // key 完全自数组
        // value key对应的setSize的个数
        Map<ArrayList<Integer>, Integer> resMap = new HashMap<>();


        // 1.所有可能收集到list
        for (int i = 0; i < nums.length -Setsize; i++) {

            // 添加 i i+1 i+2
            if( i + Setsize <= nums.length){

                ArrayList<Integer> list1 = new ArrayList<>();

                // 从i开始到 i+Setsize个数
                for (Integer integer = 0; integer < Setsize; integer++) {
                    list1.add(nums[i + integer]);
                }
                // 1,2,3
                // list.add(list1) -- 这是改变了整个list1 的引用 再添加到list中
                list.add(new ArrayList<>(list1));




                // 后续添加的数 -- 问题 20240813
                for (int j = i + Setsize ; j < nums.length ; j++) {
                    list1.add(nums[j]);

                    // 1,2,3,4
                    // 1,2,3,4,5
                    list.add(new ArrayList<>(list1));
                }
            }

        }

        System.out.println(list);

        // 2.遍历list，确定符合的数组
        for (ArrayList<Integer> integers : list) {

            HashSet<Object> set2 = new HashSet<>();
            for (int i = 0; i < integers.size(); i++) {
                set2.add(integers.get(i));
            }
            int size = set2.size();

            if(size == Setsize) {
                resMap.put(integers, size);

            }
        }

        return resMap.size();
    }


    public static void main(String[] args) {

        int[] nums = new int[]{1,3,1,2,2};
        System.out.println(Solution(nums));

    }
}
