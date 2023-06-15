package org.example.array;


//原地移除元素
public class LeetCode_27 {

    //双指针法
    public static int removeElement(int[] nums,int val) {

        int low = 0;
        for (int high = 0; high < nums.length; high++) {
            if (nums[high] != val) {
                nums[low] = nums[high];
                low++;
            }
        }
        return low;
    }



    public static void main(String[] args) {

        int [] nums  = new int[]{0,2,2,3,2,4,5,6,2};
        System.out.println(removeElement(nums, 2));

    }
}
