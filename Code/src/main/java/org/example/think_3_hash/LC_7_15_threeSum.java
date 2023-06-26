package org.example.think_3_hash;

// 三数之和
//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
// 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
// 请你返回所有和为 0 且不重复的三元组。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//三数之和（排序+双指针
public class LC_7_15_threeSum {

    // 双指针法  对了但是要去重
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if( nums[0] >0) return null;
            if( i > 0 && nums[i] == nums[i-1]) continue;

            int low = i + 1;
            int high = nums.length - 1;

            while( low < high){
                int sum  = nums[i]+nums[low]+nums[high];
                if( sum > 0) {high --;}
                else if (sum < 0){low ++;}
                else{
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    lists.add(list);

                    low++;
                    high--;
                }
            }
        }
        return lists;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {return result;}

            // 去重a
            if (i > 0 && nums[i] == nums[i - 1]) {continue;}

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {right--;}
                else if (sum < 0) {left++;}

                //对b 和 c去重
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重   0 -1 -1 -1 -1  1 1 1 1
//                    while (right > left && nums[right] == nums[right - 1]) right--;
//                    while (right > left && nums[left] == nums[left + 1])   left++;

                    // 目前未懂
                    right--;
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{-1,0,1,2,-1,-4};

        List<List<Integer>> lists = threeSum(nums);

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(" "+integer);
            }
            System.out.println();
        }
    }
}
