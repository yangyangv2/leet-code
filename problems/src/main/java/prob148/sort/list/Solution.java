package prob148.sort.list;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/4/2017.
 * Modified by yanya04 on 4/29/2017
 */
public class Solution {
    /*
        merge sort

        1. break list;
        2. merge list

    */
    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode[] lists = split(head);

        ListNode list1 = sortList(lists[0]);
        ListNode list2 = sortList(lists[1]);

        return merge(list1, list2);
    }

    private ListNode[] split(ListNode head){

        ListNode slow = new ListNode(0), fast = head;
        slow.next = fast;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        return new ListNode[]{head, next};
    }

    private ListNode merge(ListNode sorted1, ListNode sorted2){
        ListNode dummy = new ListNode(0), cur = dummy;

        while(sorted1 != null && sorted2 != null){
            if(sorted1.val < sorted2.val){
                cur.next = sorted1;
                sorted1 = sorted1.next;
            } else {
                cur.next = sorted2;
                sorted2 = sorted2.next;
            }
            cur = cur.next;
        }

        if(sorted1 != null) cur.next = sorted1;
        else cur.next = sorted2;

        return dummy.next;

    }
}
