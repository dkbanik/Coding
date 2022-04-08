package Tree;

import datastructures.Node;
import datastructures.Tree;

public class SymmetricTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.symmetricTree();
        boolean ans = isSymmetric(root);
    }

    public static boolean isSymmetric(Node root){
        if(root == null)return true;
        return match(root.getLeft(),root.getRight());
    }
    public static boolean match(Node root1, Node root2){
        if(root1!=null && root2!=null){
            boolean match1 = match(root1.getLeft(), root2.getRight());
            boolean match2 = match(root1.getRight(), root2.getLeft());
            if(root1.getData() == root2.getData() && match1 && match2)return true;
            else return false;
        }
        else if(root1 == null && root2 == null)return true;
        else return false;
    }
}
