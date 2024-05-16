package org.example.think_7_tree;


//222. 完全二叉树的节点个数
//输入：root = [1,2,3,4,5,6]
//输出：6
//题目数据保证输入的树是 完全二叉树
public class LC_6_222_countNodes {


    // 后序遍历
    // 通用的二 叉树代码
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int left_count  = countNodes(root.left);
        int right_count = countNodes(root.right);

        // 左 + 右 + 本身  节点的数量
        int count = left_count + right_count + 1;
        return count;

    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;

        n1.left.left = n4;
        n1.left.right = n5;
        n1.right.left = n6;
        System.out.println(countNodes(n1));


    }
}
