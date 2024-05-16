package org.example.think_8_backtrack_hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer_38 {

    //存放结果
    static List<List<Character>> result = new ArrayList<>();
    //暂存结果
    static List<Character> path = new ArrayList<>();

    public static List<List<Character>> permuteUnique(String s) {
        boolean[] used = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.fill(used, false);  //向used数组中全填false
        Arrays.sort(chars);
        backTrack(chars, used);
        return result;
    }

    private static void backTrack(char[] chars, boolean[] used) {
        if (path.size() == chars.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < chars.length; i++) {

            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过

            if (i > 0 && chars[i] == chars[i - 1] && used[i - 1] == false) {
                continue;
            }


            //如果同⼀树⽀nums[i]没使⽤过开始处理
            if (used[i] == false) {
                used[i] = true;//标记同⼀树⽀nums[i]使⽤过，防止同一树支重复使用
                path.add(chars[i]);

                backTrack(chars, used);

                path.remove(path.size() - 1);//回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
                used[i] = false;//回溯
            }
        }
    }

    public static void main(String[] args) {

        int [] nums = new int[]{1,2,3};
        // 1，2，3
        // “abc”
        List<List<Character>> lists = permuteUnique("abc");

        for (List<Character> list : lists) {
            for (Character character : list) {
                System.out.print(" "+character);
            }
            System.out.println();
        }
    }
}
