package prob203.remove.linked.list.elements;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/8/2017.
 * Modified by yanya04 on 5/25/2018.
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null){
            if(val == cur.next.val){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
