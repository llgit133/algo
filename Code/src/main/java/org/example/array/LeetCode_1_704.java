package org.example.array;


// 二分法[]
public class LeetCode_1_704 {


    //1、二分法[]
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left)+(right -left) / 2;
            if(nums[mid] < target) left = mid + 1;
            else if(nums[mid] > target) right  = mid - 1;
            else return mid;
        }
        return -1;
    }


    //2、二分法[)
    public static int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int mid = (left)+(right -left) / 2;
            if(nums[mid] < target) left = mid + 1;
            else if(nums[mid] > target) right  = mid;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {


       int[] nums = new int[]{1,2,3,4,5,6};
        System.out.println(search1(nums, 5));

    }
}
