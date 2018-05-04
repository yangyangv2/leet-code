package prob086.partition.list;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/5/2017.
 * Modified by yanya04 on 4/29/2018
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode res = new ListNode(0), cur = head, pre = dummy, last = res, temp = null;

        while(cur != null){
            if(cur.val < x){

                last.next = cur;
                last = last.next;

                temp = cur.next;
                cur.next = null;
                pre.next = temp;
                cur = temp;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        last.next = dummy.next;
        return res.next;
    }
}
