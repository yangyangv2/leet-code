package prob061.rotate.list;

import utils.list.ListNode;

import java.util.List;

/**
 * Created by yanya04 on 8/5/2017.
 */
public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode node = solution.rotateRight(node1, 2000000);
        ListNode.print(node);
        System.out.println(2000000000 % 3);

    }


    public ListNode rotateRight(ListNode head, int k) {
/*
Given       1->2->3->4->5->NULL and k = 2,
return      4->5->1->2->3->NULL.


    init:
        p1: dummy
        p2: dummy


    1->2->3->4->5->NULL
          p2    p1
          |--k--|

    case 1: k < length
    case 2: k == length
    case 3: k > length

    edge case              head == null || head.next == null || k = 0;


    split point            p1 at tail, p2 started

    finish                 use p2 to split

                           p1.next = head
                           head = p2.next
                           p2.next = null

*/
        if(head == null || head.next == null || k == 0) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;

        // move p1 as k steps
        int count = 0;
        while(count < k){
            if(p1.next == null){
                k = k % count;              // optimization
                if(k == 0){                 // early quit
                    return head;
                } else {
                    p1 = head;              // ready for next round
                    count = 1;
                }
            } else {
                p1 = p1.next;
                count ++;
            }
        }

        if(p1.next == null) return head;    // p1 is at the tail

        // move to split point

        while(p1.next != null){             // p1 is not at the tail
            p2 = p2.next;
            p1 = p1.next;
        }

        // p1 is at the tail and p2 has started

        // 1 -> 2 -> NULL
        // p2   p1

        p1.next = head;
        head = p2.next;
        p2.next = null;

        return head;
    }


}
