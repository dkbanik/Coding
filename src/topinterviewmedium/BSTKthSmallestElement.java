package topinterviewmedium;

public class BSTKthSmallestElement {
    static int count = 0;
    static int result = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(7);
        System.out.println(kthSmallest(root,3));

    }
    public static int kthSmallest(TreeNode root, int k) {
            inorder(root,k);
            return result;
    }

    public static void inorder(TreeNode root, int k){
        if(root.left!=null){
            kthSmallest(root.left,k);
        }
        count++;
        if(count == k){
            result = root.val;
        }
        if(root.right != null){
            kthSmallest(root.right,k);
        }
        return;
    }
}
