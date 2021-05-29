package leetcode.may2021;

import datastructures.LinkedList;
import datastructures.LinkedListNode;
import datastructures.Node;
import datastructures.Tree;

public class SortedListToBST {
    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};
        LinkedList list = new LinkedList(arr);
        LinkedListNode head = list.getHead();
        System.out.println(head.getData());
        Node root = sortedListToBST(head);
        Tree tree = new Tree();
        tree.printTree(root);
    }

    private static Node sortedListToBST(LinkedListNode head) {
        if(head == null) return null;
        LinkedListNode mid = findMid(head);
        Node root = new Node(mid.getData());
        if(mid == head) return root;
        root.setLeft(sortedListToBST(head));
        root.setRight(sortedListToBST(mid.getNext()));
        return root;
    }

    private static LinkedListNode findMid(LinkedListNode head) {
        LinkedListNode prev = head;
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast!=null && fast.getNext() != null){
            prev = slow;
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        if(prev!=null){
            prev.setNext(null);
        }
        return slow;
    }
}
