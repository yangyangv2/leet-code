package prob206.reverse.linked.list;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/7/2017.
 * Modified by yanya04 on 4/28/2018.
 * Modified by yanya04 on 5/19/2018.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode head, ListNode tail){
        if(head == null) return tail;
        ListNode next = head.next;
        head.next = tail;
        return reverseList(next, head);
    }
}