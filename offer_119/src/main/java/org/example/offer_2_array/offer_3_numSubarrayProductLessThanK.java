package org.example.offer_2_array;


//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
public class offer_3_numSubarrayProductLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod = prod *  nums[j];
            while (i <= j && prod >= k) {
                prod = prod / nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }


    public static void main(String[] args) {
        int [] nums = new int[]{10,5,2,6};
        System.out.println(numSubarrayProductLessThanK(nums,100));

    }
}
