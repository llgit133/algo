package org.example.offer_11_bit;

import java.util.HashMap;
import java.util.Map;

// 只出现一次的数
public class Offer_11_56_2 {

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {

            // map的使用 getOrDefault    若有为nums[i]、否则为0
            int a = map.getOrDefault(nums[i], 0);
            map.put(nums[i], a + 1);
        }

        for (Integer a : map.keySet()) {
            if(map.get(a) == 1) return a;
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,1,1,3};
        System.out.println(singleNumber(nums));
    }
}
