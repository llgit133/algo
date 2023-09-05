package org.example.offer_7_tree_backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Offer_1_32_1 {

    public static int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];

        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);

            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }

        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
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

        int[] ints = levelOrder(n1);
        for (int anInt : ints) {
            System.out.print(" "+anInt);
        }

    }

}
