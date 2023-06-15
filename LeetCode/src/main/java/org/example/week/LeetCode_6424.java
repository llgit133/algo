package org.example.week;

public class LeetCode_6424 {
    public static int semiOrderedPermutation(int[] nums) {

        int min_count = 0;
        int max_count = 0;

        int min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(min > nums[i]) swap(min,nums[i]);
        }

        return -1;
    }

    public static void swap(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2,4,1,3};
        System.out.println(semiOrderedPermutation(nums));

    }
}
