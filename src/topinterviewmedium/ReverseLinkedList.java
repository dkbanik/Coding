package topinterviewmedium;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println("Original List");
        printNode(node);

        ListNode head = reverse(node);
        System.out.println("Reverse List");
        printNode(head);
    }
    public static ListNode reverse(ListNode head){
        ListNode next = null;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static void printNode(ListNode head){
        while (head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }
}
