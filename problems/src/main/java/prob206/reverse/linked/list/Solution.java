package prob206.reverse.linked.list;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/7/2017.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode s = new ListNode(0);
        s.next = head;

        if(head == null || head.next == null) return head;
/*
        x->1->2->3->Null
        s
           p
              c
        insert c between s and s.next;
*/
        ListNode p = s.next;
        ListNode c = s.next.next;

        while(c != null){
            ListNode next = c.next;
            c.next = s.next;
            s.next = c;
            p.next = next;
            c = next;
        }

        return s.next;
    }
}
