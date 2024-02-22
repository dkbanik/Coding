package wrap.operations;

import wrap.datastructures.GenericNode;
import wrap.datastructures.GenericTree;

public class TreeOperations {
    public static void main(String[] args) {
        GenericTree gTree = new GenericTree(new GenericNode(1));
        //GenericNode root = gTree.buildBinaryTreeOfHeight(gTree.getRoot(),2);
        //gTree.printBinaryTree(root);
        GenericNode root = gTree.getRoot();
        root.addChild(new GenericNode(2));
        root.addChild(new GenericNode(3));
        root.addChild(new GenericNode(4));
        root.getChildren().get(0).addChild(new GenericNode(5));
        root.getChildren().get(0).addChild(new GenericNode(6));

        root.getChildren().get(1).addChild(new GenericNode(7));
        root.getChildren().get(1).addChild(new GenericNode(8));
        root.getChildren().get(1).addChild(new GenericNode(9));
        root.getChildren().get(1).addChild(new GenericNode(10));

        gTree.printTree(root);

    }
}
