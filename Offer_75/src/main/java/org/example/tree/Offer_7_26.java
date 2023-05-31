package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Offer_7_26 {

    public static boolean isSubStructure(TreeNode A, TreeNode B) {

        //1.层序遍历先找到根
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        TreeNode res = null;

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.val == B.val) {
                res = node;
                break;
            }
            if(node.left!= null) queue.add(node.left);
            if(node.right!= null) queue.add(node.right);
        }

        //2。再递归对比
        return isSameTree(res,B);
    }


    // 这是完全相同的判断
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果两个树都为空，认为它们相等
        if (p == null && q == null) {return true;}
        // 如果其中一个树为空，另一个树不为空，或者两个树的值不相等，认为它们不相等
        if (p == null || q == null || p.val != q.val) {return false;}
        // 递归比较左子树和右子树
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

        // n
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        // m
        TreeNode m1 = new TreeNode(4);
        TreeNode m2 = new TreeNode(1);
        m1.left = m2;

        System.out.println(isSubStructure(n1, m1));
    }
}
