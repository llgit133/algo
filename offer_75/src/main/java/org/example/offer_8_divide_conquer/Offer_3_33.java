package org.example.offer_8_divide_conquer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Offer_3_33 {

    public static boolean verifyPostorder(int[] postorder,TreeNode root) {

        List<Integer> list = new ArrayList<>();
        helper(list,root);

        for (int i = 0; i < postorder.length; i++) {if(postorder[i] != list.get(i)) return false;}
        return true;
    }

    public static void helper(List list, TreeNode root){
        if (root == null) return;

        // 后序遍历 结果收集list中
        helper(list, root.left);
        helper(list, root.right);
        list.add(root.val);
    }



    // 单调栈
    public static boolean verifyPostorder1(int[] postorder) {

        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;

        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;

            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }

            stack.add(postorder[i]);
        }
        return true;
    }


    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        int [] nums = new int[]{1,3,2,6,5};
        System.out.println(verifyPostorder(nums, n1));
    }
}
