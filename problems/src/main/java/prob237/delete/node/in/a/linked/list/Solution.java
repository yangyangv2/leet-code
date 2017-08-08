package prob237.delete.node.in.a.linked.list;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/7/2017.
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if(node == null) return;
        ListNode next = node.next;
        if(next == null) return;

        // copy the value of the next node
        node.val = next.val;
        node.next = next.next;
    }
}
