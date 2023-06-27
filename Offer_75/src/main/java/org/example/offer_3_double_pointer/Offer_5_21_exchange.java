package org.example.offer_3_double_pointer;

//剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4]
//注：[3,1,2,4] 也是正确的答案之一。

public class Offer_5_21_exchange {
    public static int[] exchange(int[] nums) {
        int [] res = new int[nums.length];
        int index = 0;

        // 先放奇数、再放偶数
        for (int num : nums) {
            if(num % 2 != 0) res[index++] = num;
        }

        for (int num : nums) {
            if(num % 2 == 0) res[index++] = num;
        }
        return res;
    }


    // 双指针解法
    public static int[] exchange1(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high){

            while(low < high && (nums[low] %2 == 1)) low ++;    //向右搜索第一个奇数
            while(low < high && (nums[high] %2 == 0)) high --;  // 向左搜索第一个偶数

            // 交换nums[low] 和nums[high]
            //swap(nums[low], nums[high]);

            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
        }
        return nums;
    }


    public static void swap(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }


    public static void main(String[] args) {

        int [] nums =new int[]{1,2,3,4};
        int[] ints = exchange1(nums);
        for (int anInt : ints) {
            System.out.print(" "+anInt);
        }
    }
}
