package org.example.offer_7_tree_backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer_2_32_2 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return null;

        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;

        n3.left = n4;
        n3.right = n5;

        List<List<Integer>> lists = levelOrder(n1);

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(" "+ integer);
            }
            System.out.println();
        }
    }
}
