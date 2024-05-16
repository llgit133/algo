package main.java.org.example.think_1_array;

//35.搜索插入位置
//目标值在数组所有元素之前
//目标值等于数组中某一个元素
//目标值插入数组中的位置
//目标值在数组所有元素之后
public class Lc_1_35_searchInsert {


    // 暴力解法
    public static int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= target)return i;
        }
        return nums.length;
    }

    //二分法找插入的点
    public  static int searchInsert1(int[] nums, int target) {
        int n = nums.length;

        // 定义target在左闭右闭的区间，[low, high]
        int left = 0;
        int right = n - 1;

        while (left <= right) { // 当low==high，区间[low, high]依然有效
            int mid = left + (right - left) / 2; // 防止溢出

            // target 在左区间，所以[low, mid - 1]
            if (nums[mid] > target) {right = mid - 1;}

            // target 在右区间，所以[mid + 1, high]
            else if (nums[mid] < target) {left = mid + 1;}

            // 1. 目标值等于数组中某一个元素  return mid;
            else {return mid;}
        }
        // 2.目标值在数组所有元素之前
        // 3.目标值插入数组中
        // 4.目标值在数组所有元素之后 return right + 1;
        return right + 1;
    }

    public static void main(String[] args) {

        int [] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert1(nums,9));
    }
}
