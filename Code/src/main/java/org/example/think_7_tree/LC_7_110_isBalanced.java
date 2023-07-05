package org.example.think_7_tree;

public class LC_7_110_isBalanced {


    public static boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public static int getHeight(TreeNode root){
        if (root == null) return 0;
        // 左
        int left_height = getHeight(root.left);
        if (left_height == -1) return -1;

        // 右
        int right_height = getHeight(root.right);
        if (right_height == -1) return -1;

        // 中
        int res = 0;
        if(Math.abs(left_height - right_height) > 1) return -1;
        else  res = 1 + Math.max(left_height, right_height);

        return res;
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

        System.out.println(isBalanced(n1));

        TreeNode m1 = new TreeNode(1);
        TreeNode m2 = new TreeNode(2);
        TreeNode m3 = new TreeNode(2);
        TreeNode m4 = new TreeNode(3);
        TreeNode m5 = new TreeNode(3);
        TreeNode m6 = new TreeNode(4);
        TreeNode m7 = new TreeNode(4);
        m1.left = m2;
        m1.right = m3;

        m1.left.left = m4;
        m1.left.right = m5;

        m1.left.left.left = m6;
        m1.left.left.right = m7;
        System.out.println(isBalanced(m1));
    }
}
