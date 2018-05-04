package prob092.reverse.linked.list.ii;

import utils.list.ListNode;

import java.util.List;

/**
 * Created by yanya04 on 8/6/2017.
 * Modified by yanya04 on 4/29/2018
 */
public class Solution {
    /*
        1. move m steps
        2. reverse (n - m + 1) nodes
    */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        m --; n --;
        int k = n - m + 1;

        if(m == 0) return reverse(head, k);

        ListNode cur = head, pre = null;
        while(cur != null){
            pre = cur;
            cur = cur.next;
            if(--m == 0){
                pre.next = reverse(cur, k);
                break;
            }
        }
        return head;
    }

    private ListNode reverse(ListNode head, int k){

        if(k == 0) return head;

        ListNode cur = head, pre = null, temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            if(--k == 0){
                head.next = cur;
                break;
            }
        }
        return pre;
    }
}