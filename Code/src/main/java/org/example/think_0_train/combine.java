package org.example.think_0_train;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combine {

    //1.递归函数的返回值以及参数
    //2.回溯函数终止条件
    //3.单层搜索的过程

    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    // n = 4, k = 2
    public static void backtracking(int n, int k, int startIndex){
        if (path.size() == k)  {
            result.add(new ArrayList<>(path));
            return ;
        }

        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> lists = combine(4, 2);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(" "+integer);
            }
            System.out.println();
        }
    }
}
