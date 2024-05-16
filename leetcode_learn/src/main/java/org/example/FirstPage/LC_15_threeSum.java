package org.example.FirstPage;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 三数之和

// 排序+双指针
public class LC_15_threeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {

            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {return result;}

            // 去重a
            if (i > 0 && nums[i] == nums[i - 1]) {continue;}

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {right--;}
                else if (sum < 0) {left++;}

                // sum == 0时候的去重
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left]  == nums[left  + 1]) left++;

                    // 这个操作必须有的 缩小范围
                    right--;
                    left++;
                }
            }
        }
        return result;
    }

    // 简化 没注释
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }



    public static void main(String[] args) {

        int [] num = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(num);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(" "+ integer);
            }
        }


    }
}
