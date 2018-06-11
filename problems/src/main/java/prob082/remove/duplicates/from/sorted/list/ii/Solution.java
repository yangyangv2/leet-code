package prob082.remove.duplicates.from.sorted.list.ii;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/5/2017.
 * Modified by yanya04 on 4/28/2018.
 * Modified by yanya04 on 6/10/2018.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0), cur = head, pre = dummy;
        dummy.next = head;
        boolean dup = false;

        while(cur != null){

            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
                dup = true;
            }

            if(dup){
                pre.next = cur.next;
                dup = false;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
