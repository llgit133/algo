package com.algo.easy.easy_01_array;


import java.util.LinkedHashMap;


public class lc_01_removeDuplicates {


    // 遍历数组，用map记录，如果map中存在，则count++，否则count++，map.
    public static int removeDuplicates1(int[] nums) {

        int count = 0;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {

            Integer sum = map.getOrDefault(nums[i], 0);
            if (sum == 0) count++;
            map.put(nums[i], sum + 1);
        }

        System.out.printf(String.valueOf(map));
        return count;
    }



    //双指针解决
    public static int removeDuplicates2(int[] nums) {
        //边界条件判断
        if (nums == null || nums.length == 0) return 0;

        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            //如果左指针和右指针指向的值一样，说明有重复的，这个时候，左指针不动，右指针继续往右移。
            //如果他俩指向的值不一样就把右指针指向的值往前挪
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return ++left;
    }



    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates1(nums));

        System.out.println(removeDuplicates2(nums));

    }
}




