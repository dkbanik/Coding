package datastructures;

public class LinkedList<I extends Number> {
    LinkedListNode head;
    public LinkedList(){ head = null;}

    public LinkedListNode getHead(){return head;}

    public LinkedList(int[] list){
        head = new LinkedListNode(list[0]);
        LinkedListNode current = head;
        for(int i=1;i<list.length;i++){
            current.next = new LinkedListNode(list[i]);
            current = current.next;
        }
        current.next=null;
    }

    public LinkedListNode defaultLinkedList(int size){
        head = new LinkedListNode(1);
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
