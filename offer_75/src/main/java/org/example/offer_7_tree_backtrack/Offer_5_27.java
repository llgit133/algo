package org.example.offer_7_tree_backtrack;

import java.util.LinkedList;
import java.util.Queue;


//这是一道很经典的二 叉树问题 显然，我们从根节点开始，递归地对树进行遍历，并从叶子节点先开始翻转得到镜像。
// 如果当前遍历到的节点 root 的左右两棵子树都已经翻转得到镜像， 那么我们只需要交换两棵子树的位置，即可得到以 root 为根节点的整棵子树的镜像。


public class Offer_5_27 {

    // 左、右、根
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {return null;}

        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);

        // 处理
        root.left = right;
        root.right = left;
        return root;
    }

    // 层序遍历
    public static void printTree(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(" "+node.val);
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
        }

    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(9);

        n1.left  = n2;
        n1.right = n3;

        n2.left  = n4;
        n2.right = n5;
        n3.left  = n6;
        n3.right = n7;
        printTree(n1);
        System.out.println();
        TreeNode node = mirrorTree(n1);
        printTree(node);

    }
}
