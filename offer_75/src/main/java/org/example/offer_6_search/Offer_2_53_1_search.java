package org.example.offer_6_search;


//剑指 Offer 53 - I. 在排序数组中查找数字 I
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2

public class Offer_2_53_1_search {
    public static int search(int[] nums, int target) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) k++;
        }
        return k;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{5,7,7,8,8,10};
        System.out.println(search(nums, 8));
    }
}
