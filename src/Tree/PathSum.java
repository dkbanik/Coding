package Tree;

import datastructures.Node;
import datastructures.Tree;

public class PathSum {
    static boolean hasPath = false;
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.defaultTree();
        boolean ans = pathSumV2(root, 5);
        System.out.println(pathSumV2(root,13));
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

    public static boolean pathSumV2(Node root, int target){
        if(root == null){
            return target == 0;
        }
        //if(root.getLeft()==null && root.getRight()==null && root.getData() == target)return true;
        boolean left = pathSumV2(root.getLeft(), target-root.getData());
        boolean right = pathSumV2(root.getRight(), target- root.getData());

        if(left || right){
            return true;
        }
        return false;

    }


}
