package org.example.offer_7_tree_backtrack;

public class Offer_6_28 {

    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {return true;}
        if (p == null || q == null) {return false;}

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);

        n1.left  = n2;
        n1.right = n3;
        n2.left  = n4;
        n2.right = n5;
        n3.left  = n6;
        n3.right = n7;
        System.out.println(isSymmetric(n1));
    }
}
