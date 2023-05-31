package org.example.easy.FirstPage;


public class leetcode_26 {


    //双指针
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {return 0;}

        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


    public static void main(String[] args) {

        int [] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));

    }
}

