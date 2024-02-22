package wrap.topinterviewmedium;

import static wrap.topinterviewmedium.OddEvenLinkedList.createList;

public class IntersectionLinkedList {
    public static void main(String[] args) {
        int[] commonList = {8,4,5};
        ListNode commonhead = createList(commonList);
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = commonhead;

        ListNode headB = new ListNode(4);
        headB.next = new ListNode(5);
        headB.next.next = commonhead;
        ListNode ans = getIntersectionNode(headA, headB);
        if(ans!=null) System.out.println(ans.val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currHeadA = headA;
        ListNode currHeadB = headB;
        if(currHeadA == null || currHeadB == null) return null;
        while(currHeadA != currHeadB){
            currHeadA = currHeadA.next;
            currHeadB = currHeadB.next;

            if(currHeadA == currHeadB) return currHeadA;

            if(currHeadA == null) currHeadA = headB;
            if(currHeadB == null) currHeadB = headA;

        }
        return currHeadA;
    }
}
