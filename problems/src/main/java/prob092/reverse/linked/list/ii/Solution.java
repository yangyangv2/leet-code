package prob092.reverse.linked.list.ii;

import utils.list.ListNode;

import java.util.List;

/**
 * Created by yanya04 on 8/6/2017.
 */
public class Solution {


    public static void main(String[] args) {

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node1.next = node2;

        Solution solution = new Solution();

        ListNode.print(solution.reverseBetween(node1, 1, 2));

    }


    public ListNode reverseBetween(ListNode head, int m, int n) {


        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode s = dummy;
        for (int i = 0; i < m - 1; i++) {
            s = s.next;
            if (s == null) {
                return head;
            }
        }

        if (s.next == null || s.next.next == null) return head;

        ListNode p = s.next;
        ListNode c = s.next.next;

        //                          counter
        //  x->3->5->NULL
        //  s
        //     p
        //        c

        //  x->5->3->NULL

        for (int i = 0; i < (n - m); i++) {
            ListNode next = c.next;     // null
            c.next = s.next;            // 5->3
            p.next = next;              // 3->NULL
            s.next = c;                 // x->5
            c = next;                   // c = next;

            if (c == null) {
                return dummy.next;
            }
        }

        return dummy.next;
    }
}
