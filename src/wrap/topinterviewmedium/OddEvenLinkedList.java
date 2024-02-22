package wrap.topinterviewmedium;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        int[] list = {1,2,3,4,5};
        ListNode head = createList(list);
        printNode(head);
        System.out.println();
        ListNode result = oddEvenList(head);
        printNode(result);

    }
    public static void printNode(ListNode node){
        while(node != null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
    public static ListNode createList(int[] list){
        ListNode l1 = null;
        ListNode head = null;
        for(int val : list){
            if(l1 == null){
                l1 = new ListNode(val);
                head = l1;
            }
            else{
                l1.next = new ListNode(val);
                l1 = l1.next;
            }
        }
        return head;
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode first = head;
        ListNode second = null;
        ListNode secondHead = null;
        if(first!=null && first.next != null) {
            second = first.next;
            secondHead = second;
        }


        while(first!= null && first.next!=null){
            first.next = first.next.next;
            if(first.next != null) first = first.next;
            if(first != null && first.next != null){
                second.next = first.next;
                second = first.next;
            }
            else{
                if(second != null)second.next = null;
            }

        }

        if(first != null )first.next = secondHead;
        return head;
    }
}
