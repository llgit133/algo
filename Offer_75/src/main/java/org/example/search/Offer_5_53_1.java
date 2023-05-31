package org.example.search;

public class Offer_5_53_1 {
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
