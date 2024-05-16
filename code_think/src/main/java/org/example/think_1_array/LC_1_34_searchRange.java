package main.java.org.example.think_1_array;


import com.sun.security.auth.UnixNumericUserPrincipal;

//34. 在排序数组中查找元素的第一个和最后一个位置
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]

// 二分法的变体问题
public class LC_1_34_searchRange {

    public static int[] searchRange(int[] nums, int target) {
        int left_index = getLeft(nums, target);
        int right_index = getRight(nums, target);
        return new int[]{left_index, right_index};
    }

    public static int getLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] > target) {right = mid - 1;}
            else if(nums[mid] < target) {left = mid + 1;}

            // ==
            else {
                // 最左，前面没有target
                if(mid == 0 || nums[mid - 1] != target) return mid;
                else right = mid -1;
            }
        }
        return -1;
    }


    // 最右
    public static int getRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] > target) {right = mid - 1;}
            else if(nums[mid] < target) {left = mid + 1;}
            // ==
            else {
                // 最右，后面没有target
                if(mid == nums.length - 1 || nums[mid+1] != target)return mid;
                else left = mid + 1;
            }
        }
        return -1;
    }





    public static void main(String[] args) {

        int [] nums = new int[]{5,7,7,8,8,8,8,10};
        int[] ints = searchRange(nums, 8);
        for (int anInt : ints) {
            System.out.print(" "+anInt);
        }

    }
}
