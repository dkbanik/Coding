package recursion;

import datastructures.Node;
import datastructures.Tree;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.defaultTree();
        Node node = findLCA(root, 3, 6);
        System.out.print(node.getData());
        //tree.printTree(root);
    }

    private static Node findLCA(Node node, int n1, int n2) {
        if(node == null)return null;
        if(node.getData() == n1 || node.getData() == n2) return node;

        Node l = findLCA(node.getLeft(),n1,n2);
        Node r = findLCA(node.getRight(),n1,n2);

        if(l != null & r != null)return node;
        return (l != null) ? l :r;
    }
}
