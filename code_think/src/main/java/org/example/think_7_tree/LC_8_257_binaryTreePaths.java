package org.example.think_7_tree;

import java.util.ArrayList;
import java.util.List;


//257. 二叉树的所有路径  回溯??

//   1
// /  \
// 2   3
//  \
//   5
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
public class LC_8_257_binaryTreePaths {


    //https://leetcode.cn/problems/binary-tree-paths/comments/
    static List<String> ans = new ArrayList<>();
    public static List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return ans;
        process(root,"");
        return ans;
    }

    // 不要剪枝吗
    public static void process(TreeNode x,String path){
        //
        if(x.left == null && x.right == null){
            ans.add(path == "" ? path+x.val : path+"->"+x.val);
        }
        if(x.left != null){
            process(x.left,path == "" ? path+x.val : path+"->"+x.val);
        }
        if(x.right != null){
            process(x.right,path == "" ? path+x.val : path+"->"+x.val);
        }
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        
        List<String> list = binaryTreePaths(n1);
        for (String s : list) {
            System.out.print(" "+s);
        }
    }
}
