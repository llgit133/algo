package org.example.offer_6_search;



import java.util.HashSet;
import java.util.Set;


//输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3
public class Offer_1_3 {
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
