package org.example.offer_2_array;


//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
public class offer_2_minSubArrayLen {

    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum = sum + nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum = sum - nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public static void main(String[] args) {

        int [] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));

    }
}
