package prob021.merge.two.sorted.list;

import utils.list.ListNode;

/**
 * Created by yanya04 on 7/23/2017.
 * Modified by yanya04 on 3/17/2018
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if(l1 != null){
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return dummy.next;
    }
}
