package prob025.reverse.nodes.in.k.group;

import utils.list.ListNode;

import java.util.List;
import java.util.LinkedList;

/**
 * Created by yanya04 on 7/24/2017.
 * Modified by yanya04 on 5/20/2018.
 */
public class Solution {
    /*
        k = 2
        2->1->      4->3->5

        k = 3
        3->2->1->   4->5

    */
    public ListNode reverseKGroup(ListNode head, int k) {

        int count = k;

        ListNode cur = head, pre = null, tail = null;
        while(cur != null){
            count --;
            pre = cur;
            cur = cur.next;

            if(count == 0){
                pre.next = null;
                reverse(head);
                head.next = reverseKGroup(cur, k);
                head = pre;
                break;
            }
        }
        return head;
    }


    private ListNode reverse(ListNode head){
        ListNode cur = head, pre = null, temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
