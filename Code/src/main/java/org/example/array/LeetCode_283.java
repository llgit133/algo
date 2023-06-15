package org.example.array;


//nums = [0,1,0,3,12]  输出: [1,3,12,0,0]
public class LeetCode_283 {

    public static void moveZeroes(int[] nums) {
        int low = 0;

        for (int high = 0; high < nums.length; high++) {

            if( nums[high] != 0){
//                swap(nums[high],nums[low]);
                nums[low] = nums[high];
                low ++;
            }
        }
        for (int num : nums) {
            System.out.print(" "+num);
        }
    }

    public static void swap(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    public static void main(String[] args) {

        int [] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
    }
}
