package datastructures;

public class Tree {
    Node node;
    public Tree(){
        node = null;
    }

    public Node defaultTree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }

    public Node randomTree(){
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);
        return root;
    }

    public Node symmetricTree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(3);
        return root;
    }

    public void printTree(Node root){
        if(root == null)return;
        printTree(root.left);
        System.out.print(root.data+" ");
        printTree(root.right);
    }
}
