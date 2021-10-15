package topinterviewmedium;


import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class TreeInorderIterative {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        inOrderTraversal(root);
    }

    public static void inOrderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null){

            if(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            else{
                curr = stack.pop();
                System.out.print(curr.val+" ");
                curr = curr.right;
            }
        }
    }
}
