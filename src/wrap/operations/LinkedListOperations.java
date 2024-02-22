package wrap.operations;

import wrap.datastructures.LinkedList;
import wrap.datastructures.LinkedListNode;

public class LinkedListOperations {
    public static void main(String[] args) {
        LinkedList<Number> list = new LinkedList<Number>();
        LinkedListNode head = list.defaultLinkedList(3);
        list.printLinkedList(head);
        System.out.println(list.findMiddleNode(head).getData());
    }
}
