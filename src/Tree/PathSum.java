package Tree;

import datastructures.Node;
import datastructures.Tree;

public class PathSum {
    static boolean hasPath = false;
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.defaultTree();
        boolean ans = hasPathSum(root, 5);
    }

    public static boolean hasPathSum(Node root, int targetSum) {
        if(root == null){
            return (targetSum == 0);
        }
        else {
            boolean hasPath = false;
            int subSum = targetSum - root.getData();
            if(subSum == 0 && root.getLeft() == null && root.getRight() == null) return true;
            if (root.getLeft()!=null){
                hasPath = hasPath || hasPathSum(root.getLeft(),subSum);
            }
            if (root.getRight() != null){
                hasPath = hasPath || hasPathSum(root.getRight(), subSum);
            }
            return hasPath;
        }
    }


}
