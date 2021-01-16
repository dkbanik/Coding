package datastructures;

public class Node {
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }

    public int getData(){
        return this.data;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }
}
