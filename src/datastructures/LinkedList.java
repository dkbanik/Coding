package datastructures;

public class LinkedList {
    LinkedListNode node;
    public LinkedList(){ node = null;}

    public LinkedListNode defaultLinkedList(int size){
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode current = head;
        for(int i=2;i<=size;i++){
            current.next = new LinkedListNode(i);
            current = current.next;
        }
        return head;
    }

    public void printLinkedList(LinkedListNode head){
        LinkedListNode current = head;
        while(current != null){
            System.out.print(current.getData()+"->");
            current=current.next;
        }
        System.out.println("null");
    }

    public LinkedListNode findMiddleNode(LinkedListNode head){
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }



}
