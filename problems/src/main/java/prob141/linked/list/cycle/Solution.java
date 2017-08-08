package prob141.linked.list.cycle;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/7/2017.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
/*
        X->1->2->3->4->5->6->4
slow    1 step
fast    2 steps
*/
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
