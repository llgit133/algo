package org.example.offer_7_tree_backtrack;

import java.util.ArrayList;
import java.util.List;

public class Offer_9_34 {


    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<List<Integer>> res   = new ArrayList<>();
        ArrayList<Integer> list   = new ArrayList<>();
        dfs(root, list, lists);

        for (List<Integer> integers : lists) {
            int sum = 0;
            for (Integer integer : integers) {
                sum += integer;
            }
            if(sum == target) res.add(integers);
        }
        return res;
    }

    private static void dfs(TreeNode node, List<Integer> currentPath, List<List<Integer>> paths) {
        if (node == null) {return;}

        // 将当前节点添加到当前路径中
        currentPath.add(node.val);

        // 如果是叶子节点，将当前路径添加到结果集中
        if (node.left == null && node.right == null) {
            paths.add(new ArrayList<>(currentPath));
        }

        // 递归遍历左子树和右子树
        dfs(node.left, currentPath, paths);
        dfs(node.right, currentPath, paths);

        // 回溯，移除当前节点
        currentPath.remove(currentPath.size() - 1);
    }





    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);

        n1.left =n2;
        n1.right =n3;

        n2.left = n4;
        n3.left = n5;
        n3.right = n6;

        n4.left = n7;
        n4.right = n8;

        n6.left = n9;
        n6.right = n10;


        List<List<Integer>> lists = pathSum(n1, 22);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(" "+integer);
            }
            System.out.println();
        }


    }
}

//    // 创建示例二叉树
//    TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//                root.right = new TreeNode(8);
//                root.left.left = new TreeNode(11);
//                root.right.left = new TreeNode(13);
//                root.right.right = new TreeNode(4);
//                root.left.left.left = new TreeNode(7);
//                root.left.left.right = new TreeNode(2);
//                root.right.right.left = new TreeNode(5);
//                root.right.right.right = new TreeNode(1);
