package wrap.Tree;

import wrap.datastructures.Node;
import wrap.datastructures.Tree;

public class MaximumPathSum {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.randomTree();
        int[] resultArray = {Integer.MIN_VALUE};
        int val = maxPathSum(root, resultArray);
        System.out.println(resultArray[0]);
    }
    public static int maxPathSum(Node root, int[] result){
        if(root == null)return 0;
        int leftVal = maxPathSum(root.getLeft(),result);
        int rightVal = maxPathSum(root.getRight(), result);

        int pathSumDirect = Math.max(Math.max(leftVal, rightVal)+root.getData(), root.getData());
        int pathSumRoot = Math.max(pathSumDirect, leftVal+rightVal+ root.getData());
        result[0] = Math.max(pathSumRoot, result[0]);
        return pathSumDirect;
    }
}
