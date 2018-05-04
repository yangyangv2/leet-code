package prob025.reverse.nodes.in.k.group;

import utils.list.ListNode;

import java.util.List;
import java.util.LinkedList;

/**
 * Created by yanya04 on 7/24/2017.
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
                tail = reverseKGroup(cur, k);
                head = reverse(head, k, tail);
                break;
            }
        }


        return head;
    }


    private ListNode reverse(ListNode head, int k, ListNode tail){
        ListNode cur = head, pre = null, temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            if(--k == 0) break;
        }

        head.next = tail;

        return pre;
    }



}
