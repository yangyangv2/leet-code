package prob061.rotate.list;

import utils.list.ListNode;

import java.util.List;

/**
 * Created by yanya04 on 8/5/2017.
 * Modified by yanya04 on 4/29/2018
 */
public class Solution {
    /*
        1. count the length
        2. split at (len - k % n) th (0-based)
    */
    public ListNode rotateRight(ListNode head, int k) {
        int len = len(head);
        if(len < 2) return head;

        k = k % len;

        ListNode tail = split(head, len - k);
        return merge(tail, head);
    }

    private ListNode merge(ListNode head1, ListNode head2){

        ListNode cur = head1;
        if(cur == null) return head2;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = head2;
        return head1;
    }

    private ListNode split(ListNode head, int k){
        if(k == 0) return null;
        ListNode cur = head, pre = null;
        while(cur != null){
            pre = cur;
            cur = cur.next;
            if(--k == 0){
                pre.next = null;
                return cur;
            }
        }
        return null;
    }

    private int len(ListNode head){
        int len = 0;
        while(head != null){
            len ++;
            head = head.next;
        }
        return len;
    }
}
