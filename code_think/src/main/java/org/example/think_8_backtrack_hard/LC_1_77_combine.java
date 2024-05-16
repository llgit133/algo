package org.example.think_8_backtrack_hard;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode 77 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//你可以按 任何顺序 返回答案。

public class LC_1_77_combine {


    // 一直向里面加元素不对、要回溯
    // 1 、2
    // 删除2 、回溯到1
    // 然后再从1开始  加入3       1、3
    // 把for循环抽象成递归

    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    // 1,2,3,4   2
    public static List<List<Integer>> combine(int n, int k) {

        // 初始传的是1
        combineHelper(n, k, 1);
        return result;
    }

    /**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */
    private static void combineHelper(int n, int k, int startIndex){

        //终止条件,到叶子了
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }

        // 比如当前是1   后面加入的只能是2、3、4
        // 当前是2  后面加入的只能是3、4

        // 共有三次递归 i= 1、2、3

        // 剪枝优化：i <= n - (k - path.size()) + 1
        // 未剪枝   i <= n
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            combineHelper(n, k, i + 1);  // 遍历2、3、4
            path.removeLast(); // 删除、开始回溯
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> lists = combine(4, 2);

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print("，"+integer);
            }
            System.out.println();
        }

    }
}
