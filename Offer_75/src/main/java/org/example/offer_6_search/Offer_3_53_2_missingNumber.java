package org.example.offer_6_search;


//剑指 Offer 53 - II. 0～n-1中缺失的数字
//输入: [0,1,2,3,4,5,6,7,9]
//输出: 8

public class Offer_3_53_2_missingNumber {

    public static int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int total = n * (n - 1) / 2;
        int arrSum = 0;

        for (int i = 0; i < n - 1; i++) {
            arrSum += nums[i];
        }
        return total - arrSum;
    }

    // 法二  找对应的下标



    public static void main(String[] args) {

        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(missingNumber(nums));
    }
}
