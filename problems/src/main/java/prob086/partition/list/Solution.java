package prob086.partition.list;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/5/2017.
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
/*
    Given       1->4->3->2->5->2 and x = 3,
    return      1->2->2->4->3->5

                1->4->3->2->5->2



    idea:       scan and insert

                1->4->5->3->2->5->2
                l     p   c
*/

        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = dummy;
        ListNode last = dummy;

        // case 1: 1 -> 2        (k = 0)
        // case 2: 1 -> 2        (k = 2)
        // case 2: 1 -> 2 -> 1   (k = 2)
        //         l    p    c

        while(cur != null){

            if(cur.val < x){


                // when to insert?
                // last != pre


                // insert cur to last
                // 1 -> 2 -> 3 -> 4 -> 5 -> 2 -> 1
                //           l         p    c


                if(last != pre){
                    // insertion
                    ListNode tmp = last.next;
                    last.next = cur;
                    pre.next = cur.next;
                    cur.next = tmp;
                    last = cur;
                    // 1 -> 2 -> 3 -> 2 -> 4 -> 5 -> 1
                    //           l              p    c
                    cur = pre.next;
                } else {
                    pre = cur;
                    last = pre;
                    cur = cur.next;

                }

                continue;
            } else {
                // skip >= x;
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
