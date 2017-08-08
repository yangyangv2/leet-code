package prob142.linked.list.cycle.ii;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/7/2017.
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

/*
        x->1->2->3->4->5->3
fast    0     1     2     3
slow    0  1  2  3

        x->1->2->3->4->5->2
fast    0     1     2     3
                    4
slow    0  1  2  3  4

    Solution 1, use Set

        Set<ListNode> set = new HashSet<>();

        ListNode cur = head;
        while(cur != null){
            if(set.contains(cur)){
                return cur;
            } else {
                set.add(cur);
            }
            cur = cur.next;
        }
        return null;


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

/*
        case1:      1->                 null
        case2:      1->2->              null
        case3:      1->2->2             2
        case4:      1->2->3->2          2
        case4:      1->2->3->4->2       2

*/

        if(head == null || head.next == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        ListNode slow2 = dummy;

        boolean meet = false;

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            // meet
            if(slow == fast){
                meet = true;
                break;
            }
            if(fast == null){
                return null;
            }
        }
        if(meet){
            while(slow != slow2){
                slow = slow.next;
                slow2 = slow2.next;
            }
            return slow;
        } else {

            return null;
        }
    }
}
