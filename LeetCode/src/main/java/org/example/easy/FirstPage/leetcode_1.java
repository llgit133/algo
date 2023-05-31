package org.example.easy.FirstPage;

import java.util.HashMap;
import java.util.Map;

public class leetcode_1 {
    public static int[] twoSum(int[] nums, int target) {

        // index - nums[i]
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = target-nums[i];
            if(map.containsValue(temp)) return new int[]{i,map.get(temp)};
        }

        return new int[0];
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            int temp = target-nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3,3};
        int[] ints = twoSum1(nums, 6);

        for (int anInt : ints) {
            System.out.print(" "+anInt);
        }
    }
}
