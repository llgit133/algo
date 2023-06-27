package org.example.think_8_backtrack_hard;


// 全排列会中元素有重复的情况  1、1、2
//输入：nums = [1,1,2]
//输出： [[1,1,2], [1,2,1], [2,1,1]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//示例 2：
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
public class LC_15_47_permuteUnique {

    //存放结果
    static List<List<Integer>> result = new ArrayList<>();
    //暂存结果
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backTrack(nums, used);
        return result;
    }

    private static void backTrack(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            // 1、1、2
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过  树层的去重
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过

            //nums[i] == nums[i - 1]  1、1 的情况
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {continue;}

            
            //如果同⼀树⽀nums[i]没使⽤过开始处理
            if (used[i] == false) {
                used[i] = true;//标记同⼀树⽀nums[i]使⽤过，防止同一树枝重复使用
                path.add(nums[i]);
                backTrack(nums, used);
                path.remove(path.size() - 1);//回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
                used[i] = false;//回溯
            }

        }
    }


    public static void main(String[] args) {
        int [] nums = new int[]{1,1,2};
        List<List<Integer>> lists = permuteUnique(nums);

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(" "+integer);
            }
            System.out.println();
        }
    }
}
