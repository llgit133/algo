package org.example.offer_6_search;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


//输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3
public class Offer_1_3_findRepeatNumber {
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {return num;}
            set.add(num);
        }
        return -1;
    }


    // 用了辅助数组
    public static int findRepeatNumber1(int[] nums) {

        int[] ints = new int[nums.length];
        Arrays.fill(ints, -1);
        for (int i = 0; i < nums.length; i++) {

            // 填充辅助数组中
            int temp = nums[i];
            if(ints[temp] == temp) return nums[i];
            else ints[temp] = temp;
        }
        return -1;
    }

    // 数组原地
    public static int findRepeatNumber2(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            // i != nums[i]  这是关键！！
            while( i != nums[i]){

                if(nums[i] == nums[nums[i]]){return nums[i];}

                // 交换
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber1(nums));
    }
}
