package prob143.reorder.list;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/7/2017.
 */
public class Solution {
    public void reorderList(ListNode head) {
/*
    change
        1->2->3->4->5

    into
        1->5->2->4->3

    1. find the middle, break the list
    2. reverse the second half
    3. add them in
*/
        if(head == null || head.next == null) return;

    ListNode[] lists = split(head);

    ListNode list1 = lists[0];              // list1.length >= list2.length
    ListNode list2 = reverse(lists[1]);

    // join two list together
        while(list1 != null && list2 != null){
        ListNode tmp1 = list1.next;
        list1.next = list2;
        ListNode tmp2 = list2.next;

        list2.next = tmp1;

        list1 = tmp1;
        list2 = tmp2;
    }


        return;
}


    private ListNode reverse(ListNode head){

        if(head == null || head.next == null) return head;
        ListNode s = new ListNode(0);
        s.next = head;

        ListNode p = head;
        ListNode c = head.next;

        /*
            x->5->6->7
            s  p  c

            x->6->5->7
            s     p  c
        */

        while(c != null){
            ListNode next = c.next;
            c.next = s.next;
            p.next = next;
            s.next = c;
            c = next;
        }

        return s.next;
    }

    private ListNode[] split(ListNode head){

        ListNode[] lists = new ListNode[2];

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast, slow;
        fast = dummy;
        slow = dummy;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        lists[1] = slow.next;
        lists[0] = dummy.next;
        slow.next = null;

        return lists;
    }
}
