package wrap.Tree;
/*
* https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
*
* */

public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums ={-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        displayTree(root);

    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length-1);
    }

    public static TreeNode createBST(int[] nums, int i, int j){
        if(i > j) return null;
        int mid = (i+j)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums,i, mid-1);
        root.right = createBST(nums, mid+1, j);
        return root;
    }

    public static void displayTree(TreeNode root){
        if(root == null ) return;
        System.out.println(root.val);

        displayTree(root.left);

        displayTree(root.right);

    }
}
