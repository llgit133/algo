package org.example.think_5_double_point;

public class LC_1_27_removeElement {
    //双指针法
    public static int removeElement(int[] nums,int val) {

        int low = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[low] = nums[right];
                low++;
            }
        }
        return low;
    }

}
