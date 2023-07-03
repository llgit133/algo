package org.example.offer_8_divide_conquer;


//剑指 Offer 07. 重建二叉树
//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
//假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
public class Offer_1_7_buildTree {

    //算法思路：
    //通过【前序遍历列表】确定【根节点 (root)】
    //将【中序遍历列表】的节点分割成【左分支节点】和【右分支节点】
    //递归寻找【左分支节点】中的【根节点 (left child)】和 【右分支节点】中的【根节点 (right child)】

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,preorder.length - 1,0,inorder.length - 1);
    }
    public static TreeNode build(int[] preorder, int[] inorder,int preStart,int preEnd,int inoStart,int inoEnd){
        //base case
        if(preStart > preEnd || inoStart > inoEnd){return null;}

        //树的根节点
        int val = preorder[preStart];
        TreeNode root =  new TreeNode(val);
        //查找根节点在中序遍历的位置
        int index = 0;
        for(int i = inoStart;i <= inoEnd;i++){
            if(inorder[i] == val){
                index = i;
                break;
            }
        }
        //计算左子树在数组中的长度
        int leftSize = index - inoStart;
        //递归构建。
        root.left = build(preorder,inorder,preStart + 1,preStart + leftSize,inoStart , index - 1);
        root.right = build(preorder,inorder,preStart + leftSize + 1,preEnd,index + 1 , inoEnd);
        return root;
    }


    public static void main(String[] args) {
        int [] preorder = new  int[]{3,9,20,15,7};
        int [] inorder = new  int[] {9,3,15,20,7};

        TreeNode node = buildTree(preorder, inorder);
    }
}
