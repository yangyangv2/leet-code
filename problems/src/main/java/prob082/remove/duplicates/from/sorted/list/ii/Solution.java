package prob082.remove.duplicates.from.sorted.list.ii;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/5/2017.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {

/*
        Given 1->2->3->3->4->4->5, return 1->2->5.
        Given 1->1->1->2->3, return 2->3.


        1->2->3
        1->1->2
        1->2->3->3->4->4->5
1    p1 p2
2       p1 p2
3          p1 p2
4          p1      p2
5          p1            p2
        duplicate:  p2 == p2.next  loop, p1.next = p2.next; =>  p1.next = p2.next;

        no-dup      p1 = p2, p2 = p2.next

*/
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;

        while(cur != null){

            boolean dup = false;
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
                dup = true;
            }

            if(dup){// cur.next is a new value
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;

        }
        return dummy.next;
    }
}
