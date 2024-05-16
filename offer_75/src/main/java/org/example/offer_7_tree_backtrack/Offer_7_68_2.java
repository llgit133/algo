package org.example.offer_7_tree_backtrack;

import java.util.ArrayList;
import java.util.List;

public class Offer_7_68_2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //根节点到p节点的路径
        List<TreeNode> path1 = new ArrayList<>();
        //根节点到q节点的路径
        List<TreeNode> path2 = new ArrayList<>();

        getPath(root,p,path1);
        getPath(root,q,path2);

        TreeNode result=null;
        int n = Math.min(path1.size(),path2.size());
        //保留最后一个相等的节点即为公共节点
        for(int i=0;i<n;i++){
            if(path1.get(i)==path2.get(i))
                result = path1.get(i);
        }
        return result;
    }


    //node前序遍历搜索节点p或q
    void getPath(TreeNode root,TreeNode node,List<TreeNode> path){
        if(root == null) return ;
        path.add(root);
        if(root == node) return ;

        if(path.get(path.size()-1)!=node){getPath(root.left,node,path);}
        if(path.get(path.size()-1)!=node){getPath(root.right,node,path);}

        if(path.get(path.size()-1)!=node){path.remove(path.size()-1);}
    }



    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);

        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(3);
        n1.left = new TreeNode(5);
        n1.right = new TreeNode(1);


        n1.left.left = new TreeNode(6);
        n1.left.right = new TreeNode(2);

        n1.right.left = new TreeNode(0);
        n1.right.right = new TreeNode(8);

        n1.left.right.left = new TreeNode(7);
        n1.left.right.right = new TreeNode(4);


        System.out.println(lowestCommonAncestor1(n1, n1.left, n1.left.right.right).val);
    }
}
