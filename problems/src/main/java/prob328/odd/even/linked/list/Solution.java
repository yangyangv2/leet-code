package prob328.odd.even.linked.list;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/8/2017.
 */
public class Solution {

    /*
        X->1->2->3->4->5->NULL



    */
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode odd = dummy, even = dummy, cur = dummy;
        ListNode evenHead = new ListNode(0);
        evenHead.next = head.next;

        while(cur != null && cur.next != null){
            ListNode next = cur.next.next;
            odd.next = cur.next;
            odd = odd.next;
            even.next = cur.next.next;
            even = even.next;
            cur = next;
        }

        odd.next = evenHead.next;

        return head;
    }
}
