package prob082.remove.duplicates.from.sorted.list.ii;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/5/2017.
 * Modified by yanya04 on 4/28/2018
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0), pre = dummy, cur = head;
        dummy.next = head;
        boolean hasDup = false;
        while(cur != null){
            hasDup = false;
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
                hasDup = true;
            }
            if(hasDup){
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;

    }
}
