package prob142.linked.list.cycle.ii;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/7/2017.
 * Modified by yanya04 on 4/29/2018
 */
public class Solution {

    /*
        Solution 2, not use Set

              |-------(N - 1)------|        (entry)             (meet)      (entry)
              |-------A"-----------|-----C----|---------B--------||----C------|
              |------------------A------------|
        slow    A + B + N * R
        fast    2A + 2B

              A + B + N * R = 2A + 2B
              A + B = N * R

              B + C = R

              A - C = (N - 1) R

        step 1. fast, slow, if fast gets null, return null;
        step 2. when fast, slow meets, start slow-2.
        step 3. keep moving slow and slow-2 untile they meet, then it's the entry
    */
    public ListNode detectCycle(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow1 = dummy, slow2 = dummy;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow1 = slow1.next;
            if(fast == slow1){
                // has cycle
                while(slow1 != slow2){
                    slow1 = slow1.next;
                    slow2 = slow2.next;
                }
                return slow1;
            }
        }
        // does not have cycle
        return null;

    }
}
