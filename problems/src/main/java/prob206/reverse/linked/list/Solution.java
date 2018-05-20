package prob206.reverse.linked.list;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/7/2017.
 * Modified by yanya04 on 4/28/2018.
 * Modified by yanya04 on 5/19/2018.
 * Modified by yanya04 on 5/20/2018.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        //return recursive(head, null);
        return iterative(head);
    }

    private ListNode iterative(ListNode head){

        ListNode cur = head, pre = null, temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private ListNode recursive(ListNode head, ListNode tail){
        if(head == null) return tail;
        ListNode next = head.next;
        head.next = tail;
        head = recursive(next, head);
        return head;
    }
}