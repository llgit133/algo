package org.example.offer_12_math;

import java.util.HashMap;
import java.util.Map;

public class Offer_1_39 {

    public static int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;

        //key  value
        for (int i = 0; i < length; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            //如果某个数字出现的个数已经超过数组的一半，自己返回
            if (count > length / 2) {
                return nums[i];
            }
            map.put(nums[i], count);
        }
        return -1;
    }

    public static void main(String[] args) {

        int [] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(nums));
    }
}
