package org.example.think_7_tree;


//104. 二叉树的最大深度
//    3
//   / \
//  9  20
//    /  \
//   15   7
public class LC_4_104_maxDepth {


    // 递归  后序遍历  左右根(从低向上)
    // 二 叉树的高度和深度
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left_Depth = maxDepth(root.left);
        int right_Depth = maxDepth(root.right);
        int hight = Math.max(left_Depth,right_Depth) + 1;

        return hight;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(17);

        n1.left = n2;
        n1.right = n3;

        n1.right.left = n4;
        n1.right.right = n5;

        System.out.println(maxDepth(n1));
    }
}
