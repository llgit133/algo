package org.example.offer_2_array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。

//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
// 满足 i != j、i != k 且 j != k ， 同时还满足 nums[i] + nums[j] + nums[k] == 0
public class offer_1_threeSum {


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //  去重a
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right ) {
                int sum = nums[i] + nums[left] + nums[right];

                while (left > i + 1 && left < nums.length && nums[left] == nums[left - 1]) left++;
                if (left >= right) break;

                if (sum == 0 ) {
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    left++;
                }
                else if(sum > 0) right--;
                else left++;

            }

        }

        return lists;
    }


    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = n - 1;
            while (left < right) {
                while (left > i + 1 && left < n && nums[left] == nums[left - 1]) left++;
                if (left >= right) break;
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                }
                else if (sum > 0) {right--;}
                else if (sum < 0) {left++;}
            }
        }
        return ans;
    }



    public static void main(String[] args) {

        int [] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum2(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(" "+list);
            }
            System.out.println();
        }
    }
}
