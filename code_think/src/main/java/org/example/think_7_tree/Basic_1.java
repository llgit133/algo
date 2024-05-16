package org.example.think_7_tree;

import java.util.ArrayList;
import java.util.List;

public class Basic_1 {

    List<Integer> result = new ArrayList<Integer>();

    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);// 注意这一句
        preorder(root.left, result);
        preorder(root.right, result);
    }


    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);// 注意这一句
        inorder(root.right, list);
    }


    public void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);// 注意这一句
    }


    public static void main(String[] args) {

    }
}
