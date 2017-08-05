package prob021.merge.two.sorted.list;

import utils.list.ListNode;

/**
 * Created by yanya04 on 7/23/2017.
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode dummy = head;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                dummy.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                dummy.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        while(l1 != null) {
            dummy.next = new ListNode(l1.val);
            dummy = dummy.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            dummy.next = new ListNode(l2.val);
            dummy = dummy.next;
            l2 = l2.next;
        }

        return head.next;
    }
}
