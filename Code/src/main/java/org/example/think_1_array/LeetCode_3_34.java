package org.example.think_1_array;

public class LeetCode_3_34 {


    public static int[] searchRange(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        // 情况一
        if (leftBorder == -2 || rightBorder == -2) return new int[]{-1, -1};
        // 情况三
        if (rightBorder - leftBorder > 1) return new int[]{leftBorder + 1, rightBorder - 1};
        // 情况二
        return new int[]{-1, -1};
    }

    // 1、最左
    public static int getLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int broder = -2;

        while (left <= right){
            int mid = (left)+(right -left) / 2;

            if (nums[mid] >= target) { // 寻找左边界，就要在nums[middle] == target的时候更新right
                right = mid - 1;
                broder = right;
            } else {
                left = mid + 1;
            }
        }
        return broder;
    }

    // 2、最右
    public static int getRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int broder = -2;

        while (left <= right){
            int mid = (left)+(right -left) / 2;

            if (nums[mid] > target) {
                right = mid - 1; // target 在左区间，所以[left, middle - 1]
            } else { // 当nums[middle] == target的时候，更新left，这样才能得到target的右边界
                left = mid + 1;
                broder = left;
            }
        }
        return broder;
    }



    public static void main(String[] args) {

        int [] nums = new int[]{1,2,3,4,8,8,8,8,10};

        int[] ints = searchRange(nums,8);
        for (int anInt : ints) {
            System.out.print(" " +anInt);
        }
    }
}
