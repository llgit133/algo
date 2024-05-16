package org.example.think_8_backtrack_hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 全排列不重复
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

public class LC_14_46_permute {

    static List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    static LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    static boolean[] used;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0){
            return result;
        }
        used = new boolean[nums.length];  //默认全为0
        permuteHelper(nums);
        return result;
    }

    private static void permuteHelper(int[] nums){
        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }


        for (int i = 0; i < nums.length; i++){
            if (used[i]){continue;}

            used[i] = true;
            path.add(nums[i]);

            permuteHelper(nums);

            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {

        int [] nums = new int[]{1,2,3};
        List<List<Integer>> lists = permuteUnique(nums);

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(" "+integer);
            }
            System.out.println();
        }
    }
}
