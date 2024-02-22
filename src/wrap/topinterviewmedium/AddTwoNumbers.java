package wrap.topinterviewmedium;
class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1= new ListNode(3);
        l1.next = new ListNode(7);
        //l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(2);
        //l2.next.next = new ListNode(4);
        printNode(l1);
        System.out.println();
        printNode(l2);

        ListNode result = addTwoNumbers(l1,l2);
        System.out.println();
        printNode(result);
    }


    public static void printNode(ListNode node){
        while(node != null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l3 = null;
        ListNode head = null;
        while(l1 != null && l2 != null){
            int val = (l1.val+l2.val+carry)%10;
            if(l3 == null){
                l3 = new ListNode(val);
                head = l3;
            }else{
                l3.next= new ListNode(val);
                l3 = l3.next;
            }
            carry = (l1.val+l2.val+carry)/10;
            l1 = l1.next;
            l2 = l2.next;

        }

        while(l1 != null){
            int val = (l1.val+carry)%10;
            l3.next = new ListNode(val);
            carry = (l1.val+carry)/10;
            l1 = l1.next;
            l3 = l3.next;
        }
        while(l2 != null){
            int val = (l2.val+carry)%10;
            l3.next = new ListNode(val);
            carry = (l2.val+carry)/10;
            l2=l2.next;
            l3 = l3.next;
        }

        if(carry != 0) l3.next = new ListNode(carry);
        return head;
    }
}
