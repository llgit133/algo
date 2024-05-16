package org.example.think_7_tree;

import java.util.LinkedList;
import java.util.Queue;

//针对二叉树的问题，解题之前一定要想清楚究竟是   前中后序遍历，还是层序遍历。

//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
public class LC_2_226_invertTree {


    //1、递归法

    //我们来看一下递归三部曲：
    //1、确定递归函数的参数和返回值
    //2、确定终止条件
    //3、确定单层递归的逻辑

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


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {return null;}

        invertTree(root.left);
        invertTree(root.right);

        swapChildren(root);
        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }


    // 1、先序遍历--从顶向下交换
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        // 保存右子树
        TreeNode rightTree = root.right;
        // 交换左右子树的位置
        root.right = invertTree(root.left);
        root.left  = invertTree(rightTree);
        return root;
    }


    //2、利用中序遍历
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left); // 递归找到左节点
        TreeNode rightNode= root.right; // 保存右节点
        root.right = root.left;
        root.left = rightNode;
        // 递归找到右节点 继续交换 : 因为此时左右节点已经交换了,所以此时的右节点为root.left
        invertTree(root.left);
        return root;
    }

    //3、利用后序遍历！！！！！！
    public TreeNode invertTree3(TreeNode root) {
        // 后序遍历-- 从下向上交换
        if (root == null) return null;
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.right = leftNode;
        root.left = rightNode;
        return root;
    }


    //4、利用层次遍历
    public TreeNode invertTree4(TreeNode root) {
        // 层次遍历--直接左右交换即可
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            // 交换
            TreeNode rightTree = node.right;
            node.right = node.left;
            node.left = rightTree;

            //进队
            if (node.left != null){queue.offer(node.left);}
            if (node.right != null){queue.offer(node.right);}
        }
        return root;
    }




    //2、迭代法

    public static void main(String[] args) {

    }
}
