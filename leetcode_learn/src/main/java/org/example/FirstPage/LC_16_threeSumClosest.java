package org.example.FirstPage;

import java.util.Arrays;

//16. 最接近的三数之和
//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
//返回这三个数的和。
//假定每组输入只存在恰好一个解。


//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
public class LC_16_threeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];

        for(int i = 0;i < nums.length;i++) {
            int start = i + 1 ;
            int end   = nums.length - 1;

            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];

                if(Math.abs(target - sum) < Math.abs(target - ans)) ans = sum;
                if(sum > target) end--;
                else if(sum < target) start++;
                else return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int [] nums = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }
}
