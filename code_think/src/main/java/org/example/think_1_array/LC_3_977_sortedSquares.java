package org.example.think_1_array;


import javax.print.attribute.standard.PrinterURI;
import java.util.Arrays;

//977.有序数组的平方
// 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按非递减顺序排序。
// 示例 1： 输入：nums = [-4,-1,0,3,10] 输出：[0,1,9,16,100]
// 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
// 示例 2： 输入：nums = [-7,-3,2,3,11] 输出：[4,9,9,49,121]
public class LC_3_977_sortedSquares {



    // 1、暴力法
    // 每个数平方之后，排个序，美滋滋
    public static int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] =  nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }



        // 2、双指针+辅助数组
    //数组其实是有序的， 只不过负数平方之后可能成为最大数了。
    //那么数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间。
    //此时可以考虑双指针法了，i指向起始位置，j指向终止位置。
    //定义一个新数组result，和A数组一样的大小，让k指向result数组终止位置。
    //如果A[i] * A[i] < A[j] * A[j]  那么result[k--] = A[j] * A[j]; 。
    //如果A[i] * A[i] >= A[j] * A[j] 那么result[k--] = A[i] * A[i]; 。

    public static int[] sortedSquares1(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        // res数组 从后向前收集
        int[] result = new int[nums.length];
        int index = result.length - 1;

        // 双指针开始 left++  right--   nums[] 是有序数组
        while (left <= right) {

            int left_pow = nums[left] * nums[left];
            int right_pow = nums[right] * nums[right];
            if (left_pow > right_pow) {
                // 正数的相对位置是不变的， 需要调整的是负数平方后的相对位置
                result[index] = left_pow;
                index --;
                left ++;
            }
            else {
                result[index] = right_pow;
                index --;
                right --;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int [] nums = new int[]{-4,-1,0,3,10};
        int[] ints = sortedSquares1(nums);
        for (int anInt : ints) {
            System.out.print(" "+anInt);
        }

    }
}
