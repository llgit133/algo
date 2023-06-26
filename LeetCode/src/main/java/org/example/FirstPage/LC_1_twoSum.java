package org.example.FirstPage;


//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

import java.util.HashMap;

public class LC_1_twoSum {

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {return new int[]{map.get(temp), i};}
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {


        int [] nums = new int[]{2, 7, 11, 15};
        int[] ints = twoSum(nums, 9);

        for (int anInt : ints) {
            System.out.print(" "+anInt);
        }
    }
}
