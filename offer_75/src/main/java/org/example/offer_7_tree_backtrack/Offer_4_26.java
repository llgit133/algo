package org.example.offer_7_tree_backtrack;

import java.util.LinkedList;
import java.util.Queue;



// 树的子结构   判断B是否为A的子树

public class Offer_4_26 {

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
        return helper(res,B);
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


    // 这是包含判断   理解了
    // B是否在A内
    private static boolean helper(TreeNode nodeA, TreeNode nodeB){
        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();
        queueA.offer(nodeA);
        queueB.offer(nodeB);

        while(!queueB.isEmpty()){
            nodeA = queueA.poll();
            nodeB = queueB.poll();

            // nodeA == null nodeA没有但是nodeB有        ❌
            // nodeA.val != nodeB.val 都有到但是值不相同   ❌
            if(nodeA == null || nodeA.val != nodeB.val){
                return false;
            }
            if(nodeB.left != null){
                queueA.offer(nodeA.left);
                queueB.offer(nodeB.left);
            }
            if(nodeB.right != null){
                queueA.offer(nodeA.right);
                queueB.offer(nodeB.right);
            }
        }
        return true;
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
