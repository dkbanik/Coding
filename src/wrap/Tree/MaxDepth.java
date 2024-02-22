package wrap.Tree;

import wrap.datastructures.Node;
import wrap.datastructures.Tree;

public class MaxDepth {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.randomTree();
        int ans = maxDepth(root);
    }

    public static int maxDepth(Node root){
        if(root == null)return 0;
        return Math.max(maxDepth(root.getLeft()),maxDepth(root.getRight()))+1;
    }
}
