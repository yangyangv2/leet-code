package prob019.remove.nth.node.from.end.of.list;

/**
 * Created by yanya04 on 7/23/2017.
 */
public class Solution {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // 0 -> 1 -> 2 -> 3 -> 4 -> 5

        int counter = 0;
        while(first != null){
            first = first.next;
            if(counter > n){
                second = second.next;
            }
            counter ++;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
