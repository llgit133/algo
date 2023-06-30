package org.example.think_8_backtrack_hard;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//解释:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9


//输入: k = 3, n = 7
//输出: [[1,2,4]]
//解释:
//1 + 2 + 4 = 7
//没有其他符合的组合了。
public class LC_2_216_combinationSum3 {

    //targetSum（int）目标和，也就是题目中的n。
    //k（int）就是题目中要求k个数的集合。
    //sum（int）为已经收集的元素的总和，也就是path里元素的总和。
    //startIndex（int）为下一层for循环搜索的起始位置。


    static List<List<Integer>> ans = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    public static List<List<Integer>> combinationSum3(int k, int n) {
        build(k, n, 1, 0);
        return ans;
    }

    private static void build(int k, int n, int startIndex, int sum) {

        if (sum > n) return;

        if (path.size() > k) return;

        if (sum == n && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum = sum + i;
            build(k, n, i + 1, sum);

            //回溯
            sum = sum - i;
            path.removeLast();
        }
    }



    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3(3, 7);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(" "+integer);
            }
            System.out.println();
        }

    }
}
