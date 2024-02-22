package wrap.problems.lrucache;


public class DoublyLinkedList{

    DoublyLLNode head;
    DoublyLLNode tail;
    DoublyLLNode current;
    int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.size = 0;
    }

    public int getSize(){
        current = tail;
        if(head == null || current == null) return 0;
        int count = 0;
        while(head != current && current!=null){
            count++;
            current = current.next;
        }
        return ++count;
    }

    public DoublyLLNode add(DoublyLLNode node){
        if(node == null) return null;
        if(head == null){
            head = node;
            tail = head;
            current = head;
            head.next = null;
        }
        else{
            current = node;
            head.next = current;
            current.prev = head;
            head = current;
            head.next = null;
        }
        return head;
    }

    public void eject(){
        if(tail!=null){
            current = tail;
            tail = current.next;
            if(tail !=null) tail.prev = null;
        }
    }

    public DoublyLLNode replaceNodeToFront(DoublyLLNode node){
        DoublyLLNode nodeAhead = node.next;
        DoublyLLNode nodeBehind = node.prev;
        current = node;

        if(node == tail){
            tail = current.next;
            tail.prev = null;
        } else{
            nodeBehind.next = nodeAhead;
            nodeAhead.prev = nodeBehind;
        }
        head.next = current;
        current.prev = head;
        head = current;
        head.next = null;
        return head;
    }

    public void printList(){
        current = tail;
        while(current!=null){
            System.out.print(current.value+", ");
            current=current.next;
        }
        System.out.println();
    }


}
