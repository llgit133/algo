package org.example.think_3_hash;

import java.util.HashMap;
import java.util.Map;

//  两数之和
public class LC_4_1_twoSum {

    public  static int[] twoSum(int[] nums, int target) {

        // 存储遍历过的元素
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }


    public static void main(String[] args) {

        int [] nums = new int[]{2,7,11,15};
        int[] ints = twoSum(nums, 9);
        for (int anInt : ints) {
            System.out.print(" "+anInt);
        }

    }
}
