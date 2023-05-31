package org.example.search;

public class Offer_5_53_2 {

    public static int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int total = n * (n - 1) / 2;
        int arrSum = 0;

        for (int i = 0; i < n - 1; i++) {
            arrSum += nums[i];
        }
        return total - arrSum;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(missingNumber(nums));
    }
}
