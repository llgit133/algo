package org.example.offer_3_double_pointer;


//剑指 Offer 57. 和为s的两个数字
//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
//输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]

public class Offer_6_57_twoSum {

    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int sum = nums[i] + nums[j];
            if(sum < target) i++;
            else if(sum > target) j--;
            else return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int[] ints = twoSum(nums, 9);
        for (int anInt : ints) {
            System.out.print(" " + anInt);
        }
    }
}
