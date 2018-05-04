package prob141.linked.list.cycle;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/7/2017.
 * Modified by yanya04 on 4/29/2018
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy = head;
        ListNode fast = head, slow = dummy;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}