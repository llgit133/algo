package org.example.offer_7_tree_backtrack;

import java.util.LinkedList;
import java.util.Queue;

public class Offer_7_37_hard {


    // 层序遍历输出字符串！！
    //[1,2,3,null,null,4,5]
    public static String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder("[");

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
            res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else res.append("null,");
        }

        // 删除最后一个,
        res.deleteCharAt(res.length() - 1);

        res.append("]");
        return res.toString();
    }



    public static TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;

        // 1,2,3,null,null,4,5    要括号里面的元素、以逗号分开、进数组
        String[] vals = data.substring(1, data.length() - 1).split(",");

        // 根为1
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // 先左
            if(!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;

            // 后右
            if(!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;

        n3.left = n4;
        n3.right = n5;

        String s = serialize(n1);
        System.out.println(s);

        TreeNode node = deserialize(s);
        System.out.println(node.val);
    }
}
