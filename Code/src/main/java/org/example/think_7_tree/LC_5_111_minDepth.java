package org.example.think_7_tree;



//最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//    1
//     \
//     2
//    /  \
//   3   6
//       /
//      5
public class LC_5_111_minDepth {


    //后序遍历
    public static int minDepth(TreeNode root) {

        if(root == null) return 0;

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // 与最大深度不同点
        if (root.left == null && root.right != null)  {return rightDepth + 1;}
        if (root.left != null && root.right == null)  {return leftDepth + 1;}

        // 左右结点都不为null
        int height = Math.min(leftDepth, rightDepth) + 1;
        return height;
    }



    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5);

        n1.right = n2;
        n1.right.left = n3;

        n1.right.right = n4;
        n1.right.right.left = n5;

        System.out.println(minDepth(n1));
    }
}
