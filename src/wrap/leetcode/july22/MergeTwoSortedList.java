package wrap.leetcode.july22;

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

public class MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode list1 = null;//new ListNode(1);
        //list1.next = new ListNode(2);
        //list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
//        list2.next = new ListNode(3);
//        list2.next.next = new ListNode(4);

        ListNode node = mergeTwoLists(list1,list2);
        display(list1);
        System.out.println();
        display(node);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = null;
        ListNode head = null;
        ListNode newHead = null;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp = new ListNode(list1.val);
                if(newHead == null){
                    newHead = temp;
                    head = newHead;
                }
                else{
                    newHead.next = temp;
                    newHead = newHead.next;
                }

                list1 = list1.next;
            }
            else if(list2.val < list1.val){
                temp = new ListNode(list2.val);
                if(newHead == null){
                    newHead = temp;
                    head = newHead;
                }
                else{
                    newHead.next = temp;
                    newHead = newHead.next;
                }
                list2 = list2.next;
            }
            else{
                temp = new ListNode(list1.val);
                if(newHead == null){
                    newHead = temp;
                    head = newHead;
                }
                else{
                    newHead.next = temp;
                    newHead = newHead.next;
                }
                newHead.next = new ListNode(list2.val);
                newHead = newHead.next;
                list1 = list1.next;
                list2 = list2.next;
            }
        }

        while(list1 != null){
            temp = new ListNode(list1.val);
            if(newHead == null){
                newHead = temp;
                head = newHead;
            }
            else{
                newHead.next = temp;
                newHead = newHead.next;
            }
            list1 = list1.next;
        }

        while(list2 != null){
            temp = new ListNode(list2.val);
            if(newHead == null){
                newHead = temp;
                head = newHead;
            }
            else{
                newHead.next = temp;
                newHead = newHead.next;
            }
            list2 = list2.next;
        }


        return head;
    }

    public static void display(ListNode node){
        while(node != null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
}
