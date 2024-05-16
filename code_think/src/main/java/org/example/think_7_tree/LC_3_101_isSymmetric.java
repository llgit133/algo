package org.example.think_7_tree;

import java.util.LinkedList;
import java.util.Queue;


//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//输入：root = [1,2,2,3,4,4,3]
//输出：true



//输入：root = [1,2,2,null,3,null,3]
//输出：false

//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
public class LC_3_101_isSymmetric {


    // 1、递归法
    // 后序 左右根  收集孩子的信息向上一层返回

    // 三部曲
    // 1、定义递归函数
    // 2、确定终止条件
    // 3、单层递归逻辑
    public static boolean isSymmetric(TreeNode root) {

        return compare(root.left, root.right);
    }
    public static boolean compare(TreeNode left,TreeNode right) {
        // 2、
        if(left == null && right != null )return false;
        else if (left != null && right == null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;

        //剩下的就是 左右 节点都不为空，且数值相同的情况
        //3、单层递归逻辑
        boolean Outside = compare(left.left,right.right); // 比较外侧
        boolean Inside  = compare(left.right,right.left); // 比较内侧
        boolean res = Outside && Inside;  // 左 右孩子处理完之后才能得出结论，所以只能后序
        return res;
    }



    // 2、迭代法  层序遍历、使用普通队列
    public static boolean isSymmetric1(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);

        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.poll();
            TreeNode rightNode = deque.poll();

            if (leftNode == null && rightNode == null) {continue;}

            // 以上三个判断条件合并
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }

            // 这里顺序与使用Deque不同  左右孩子可否相互翻转
            //外侧
            deque.offer(leftNode.left);
            deque.offer(rightNode.right);

            // 内侧
            deque.offer(leftNode.right);
            deque.offer(rightNode.left);
        }
        return true;
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;

        n1.left.left = n4;
        n1.left.right = n5;

        n1.right.left = n6;
        n1.right.right = n7;

        System.out.println(isSymmetric(n1));

    }
}
