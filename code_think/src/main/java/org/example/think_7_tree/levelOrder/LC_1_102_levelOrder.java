package org.example.think_7_tree.levelOrder;


import org.example.think_7_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//102.二叉树的层序遍历
//107.二叉树的层次遍历II
//199.二叉树的右视图
//637.二叉树的层平均值
//429.N叉树的层序遍历
//515.在每个树行中找最大值
//116.填充每个节点的下一个右侧节点指针
//117.填充每个节点的下一个右侧节点指针II
//104.二叉树的最大深度
//111.二叉树的最小深度



//二叉树的层序遍历
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
public class LC_1_102_levelOrder {


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < queue.size(); i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);

                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            lists.add(list);
        }
        return lists;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        if(root != null) queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {

                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {



    }
}
