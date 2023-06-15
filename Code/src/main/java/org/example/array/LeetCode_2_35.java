package org.example.array;

//35.搜索插入位置
//目标值在数组所有元素之前
//目标值等于数组中某一个元素
//目标值插入数组中的位置
//目标值在数组所有元素之后
public class LeetCode_2_35 {

    public static int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= target)return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {

        int [] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums,9));
    }
}
