package wrap.Tree;

import wrap.Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TreeFromPreInOrder {
    static int preIndex = 0;
    public static void main(String[] args) {
        //int[] pre = {3,9,20,15,7};
        //int[] in = {9,3,15,20,7};
        int[] in = {-1};
        int[] pre = {-1};

        TreeNode root = buildTree(pre, in);
        inOrderTraversal(root);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> searchMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            searchMap.put(inorder[i],i);
        }
        return buildTree(preorder,inorder,0,inorder.length-1,searchMap);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int start, int end, Map<Integer, Integer> searchMap){
        if(start>end)return null;

        int val = preorder[preIndex++];
        TreeNode curr = new TreeNode(val);

        if(start==end)return curr;

        int inIndex = searchMap.get(curr.val);

        curr.left = buildTree(preorder,inorder,start,inIndex-1,searchMap);
        curr.right = buildTree(preorder,inorder,inIndex+1,end,searchMap);
        return curr;
    }

    public static void inOrderTraversal(TreeNode root){
        if(root == null)return;
        inOrderTraversal(root.left);
        System.out.print(root.val+",");
        inOrderTraversal(root.right);
    }
}
