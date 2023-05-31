package org.example.search;


import java.util.HashSet;
import java.util.Set;

public class Offer_5_3 {
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {return num;}
            set.add(num);
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }
}
