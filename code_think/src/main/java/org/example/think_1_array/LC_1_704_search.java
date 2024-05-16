package org.example.think_1_array;


// 二分法[]
public class LC_1_704_search {


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
    public static int search2(int[] nums, int target) {
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

    //3、二分变体1
    //4、二分变体2
    //5、二分变体3
    //6、二分变体4

    //3、最左 if (mid == 0 || nums[mid - 1] != target){return mid;}
    public static int search3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left)+(right -left) / 2;
            if(nums[mid] == target){
                if (mid == 0 || nums[mid - 1] != target){return mid;}
                else right = mid - 1;
            }
            else if(nums[mid] < target) left = mid + 1;
            else right  = mid - 1;

        }
        return -1;
    }


    //4、最右 if (mid == nums.length -1 || nums[mid + 1] != target){return mid;}
    public static int search4(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left)+(right -left) / 2;
            if(nums[mid] == target){
                if (mid == nums.length -1 || nums[mid + 1] != target){return mid;}
                else left = mid + 1;
            }
            else if(nums[mid] < target) left = mid + 1;
            else right  = mid - 1;

        }
        return -1;
    }

    //5、大于等于最小  if (mid == 0 || nums[mid - 1] < target){return mid;}
    public static int search5(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left)+(right -left) / 2;

            // >=
            if(nums[mid] >= target){
                if (mid == 0 || nums[mid - 1] < target){return mid;}
                else right = mid - 1;
            }
            else if(nums[mid] < target) left = mid + 1;
            else right  = mid - 1;

        }
        return -1;
    }

    //6、小于等于最大  if (mid == nums.length - 1 || nums[mid + 1] > target){return mid;}
    public static int search6(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left)+(right -left) / 2;

            // <=
            if(nums[mid] <= target){
                if (mid == nums.length - 1 || nums[mid + 1] > target){return mid;}
                else left = mid + 1;
            }
            else if(nums[mid] < target) left = mid + 1;
            else right  = mid - 1;

        }
        return -1;
    }


    public static void main(String[] args) {


       int[] nums = new int[]{1,3,4,5,6,8,8,8,11,13};
        System.out.println(search(nums, 3));   //[]
        System.out.println(search2(nums, 3));  //[)
        System.out.println(search3(nums, 8));  //最右
        System.out.println(search4(nums, 8));  //最左
        System.out.println(search5(nums, 6));  //大于等于最小
        System.out.println(search6(nums, 10));  //小于等于最大
    }
}
