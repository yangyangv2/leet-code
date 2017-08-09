package prob369.plus.one.linked.list;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/8/2017.
 */
public class Solution {

/*
    idea

    1) reverse the list
    2) add one with carry number
*/

    public ListNode plusOne(ListNode head) {

        ListNode reversed = reverse(head);

        ListNode cur = reversed;

        int carry = 1;

        while(cur != null){
            int sum = cur.val + carry;
            if(sum < 10){
                cur.val = sum;
                carry = 0;
                break;
            } else {
                cur.val = sum % 10;
                carry = sum / 10;
                if(cur.next == null){
                    cur.next = new ListNode(carry);
                    break;
                } else {
                    cur = cur.next;
                }
            }
        }

        reversed = reverse(reversed);
        return reversed;
    }


    /*
        X->1->2->3->4->NULL

    */

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode reversed = new ListNode(0);
        ListNode cur = head;

        while(cur != null){
            ListNode tmp = reversed.next;
            ListNode next = cur.next;
            reversed.next = cur;
            cur.next = tmp;
            cur = next;
        }
        head.next = null;
        return reversed.next;
    }
}
