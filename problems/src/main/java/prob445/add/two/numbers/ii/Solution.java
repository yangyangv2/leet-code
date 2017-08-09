package prob445.add.two.numbers.ii;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/8/2017.
 */
public class Solution {


/*
    1. reverse
    2. add with carry
    3. reverse back
*/


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode result = new ListNode(0);
        ListNode cur3 = result;

        int carry = 0;
        while(cur1 != null && cur2 != null){
            int sum = cur1.val + cur2.val + carry;
            if(sum < 10){
                cur3.next = new ListNode(sum);
                carry = 0;
            } else {
                cur3.next = new ListNode(sum % 10);
                carry = sum / 10;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
            cur3 = cur3.next;
        }

        while(cur1 != null){
            int sum = cur1.val + carry;
            if(sum < 10){
                cur3.next = new ListNode(sum);
                carry = 0;
            } else {
                cur3.next = new ListNode(sum % 10);
                carry = sum / 10;
            }
            cur1 = cur1.next;
            cur3 = cur3.next;
        }

        while(cur2 != null){
            int sum = cur2.val + carry;
            if(sum < 10){
                cur3.next = new ListNode(sum);
                carry = 0;
            } else {
                cur3.next = new ListNode(sum % 10);
                carry = sum / 10;
            }
            cur2 = cur2.next;
            cur3 = cur3.next;
        }

        if(carry > 0){
            cur3.next = new ListNode(carry);
        }

        return reverse(result.next);
    }


    private ListNode reverse(ListNode head){

        if(head == null || head.next == null) return head;

        ListNode reversed = new ListNode(0);

        ListNode cur = head;

        while(cur != null){
            ListNode next = cur.next;
            ListNode tmp = reversed.next;
            reversed.next = cur;
            cur.next = tmp;
            cur = next;
        }

        return reversed.next;
    }
}
