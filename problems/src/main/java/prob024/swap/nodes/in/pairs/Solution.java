package prob024.swap.nodes.in.pairs;

/**
 * Created by yanya04 on 7/23/2017.
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while(p != null){
            ListNode node1 = p.next;
            if(node1 != null){
                ListNode node2 = node1.next;
                if(node2 == null) break; // reach the last node (odd number)
                p.next = node2;
                ListNode follow = node2.next;
                node2.next = node1;
                node1.next = follow;
                // move cursor
                p = node1;
            } else break;               // reach the last node (even number)
        }
        return dummy.next;
    }
}
