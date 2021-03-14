package datastructures;

public class LinkedListNode {
    int data;
    LinkedListNode next;
    LinkedListNode(int data){
        this.data = data;
        this.next = null;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public int getData() {
        return data;
    }
}
