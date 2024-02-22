package wrap.datastructures;

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

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }
}
