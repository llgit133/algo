package org.example.think_1_array;

public class LeetCode_704 {

    // 1、第一种写法，我们定义 target 是在一个在左闭右闭的区间里，也就是[left, right]
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

    //2、如果说定义 target 是在一个在左闭右开的区间里，也就是[left, right)
    public static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        // 因为left == right的时候，在[left, right)是无效的空间，所以使用 <
        while (left < right) {
            int mid = left + ((right - left) >> 1);

            // target 在左区间，在[left, middle)中
            if (nums[mid] > target) right = mid;
            // target 在左区间，在[left, middle)中
            else if (nums[mid] < target) left = mid + 1;
            else {return mid;}
        }
        return -1;
    }


    public static void main(String[] args) {

        int [] nums = new int[]{-1,0,3,5,9,12};
        System.err.println(search(nums, -1));
    }
}
