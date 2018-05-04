package prob143.reorder.list;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/7/2017.
 * Modified by yanya04 on 4/29/2018
 */
public class Solution {

    /*
        1. split by half
        2. reverse the second half
        3. merge
    */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode second = split(head);
        ListNode reversed = reverse(second);
        merge(head,  reversed);
    }

    private ListNode split(ListNode head){

        ListNode slow = new ListNode(0), fast = head;
        slow.next = fast;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        return res;
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

    private void merge(ListNode list1, ListNode list2){
        ListNode cur = new ListNode(0);
        while(list1 != null && list2 != null){
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;

            cur.next = list2;
            list2 = list2.next;
            cur = cur.next;
        }
        if(list1 != null){
            cur.next = list1;
        } else {
            cur.next = list2;
        }
    }
}