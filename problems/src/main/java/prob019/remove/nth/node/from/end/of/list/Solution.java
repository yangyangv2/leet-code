package prob019.remove.nth.node.from.end.of.list;

import utils.list.ListNode;

/**
 * Created by yanya04 on 7/23/2017.
 * Modified by yanya04 on 4/29/2018
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        int count = 0;
        /*
            1->2->3->4->5

        c   1  2  3  4  5

            n = 1: delete 5
            n = 2: delete 4
            n = 3: delete 3
            ..
            n = 5: delete 1

          n = 2 (remove 4)

            1->2->3->4->5
          f f  f  f  f  f
          s s  s  s  s
          c 1  2  3  4  5
        */
        boolean delete = false;
        while(fast != null){
            fast = fast.next;
            count ++;
            if(count == n + 1) delete = true;
            if(count > n + 1) slow = slow.next;
        }
        // delete node
        if(delete) slow.next = slow.next.next;
        return dummy.next;
    }
}