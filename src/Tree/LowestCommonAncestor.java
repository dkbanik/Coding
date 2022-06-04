package Tree;

import datastructures.Node;
import datastructures.Tree;

//https://www.youtube.com/watch?v=_-QHfMDde90
public class LowestCommonAncestor {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node head = tree.randomTree();

        Node ans = findLCA(head,2,7);
        System.out.println(ans.getData());
    }

    public static Node findLCA(Node root, int p, int q){

        if(root == null || root.getData() == p || root.getData() == q){
            return root;
        }

        Node left = findLCA(root.getLeft(),p,q);
        Node right = findLCA(root.getRight(),p,q);

        if(left == null){
            return right;
        }
        else if(right == null){
            return left;
        }
        else{
            return root;
        }
    }
}
