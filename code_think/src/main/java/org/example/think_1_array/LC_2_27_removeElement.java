package org.example.think_1_array;


//原地移除元素
//输入：nums = [3,2,2,3], val = 3
//输出：2, nums = [2,2]
//解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。
//例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。

public class LC_2_27_removeElement {

    //双指针法 left  right
    // left 经过 0、3、4、5、6
    public static int removeElement(int[] nums, int val) {

        int left= 0;
        for (int right = 0; right < nums.length; right++) {

            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }



    public static void main(String[] args) {

        int [] nums  = new int[]{0,2,2,3,2,4,5,6,2};
        System.out.println(removeElement(nums, 2));

    }
}
