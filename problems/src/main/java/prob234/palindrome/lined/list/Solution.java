package prob234.palindrome.lined.list;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/6/2017.
 */
public class Solution {
    // palindrome

    // case 1:  1                           [true]
    // case 2:  1 -> 1                      [true]
    // case 3:  1 -> 2                      [false]
    // case 4:  1 -> 2 -> 1                 [true]
    // case 5:  1 -> 2 -> 2 -> 1            [true]
    // case 6:  1 -> 2 -> 1 -> 1            [false]
    // case 7:  1 -> 2 -> 3 -> 2 -> 1       [true]
    // case 8:  1 -> 2 -> 1 -> 1 -> 1       [false]


    // idea

    // split into two
    // reverse first half

    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null) return true;



        // reverse first half, two pointers
        //           (slow)
        //    1-> 2 -> 3 -> ....
        // p  c

        //    2-> 1 -> 3 -> ....
        // p      c



        ListNode[] lists = split(head);
        ListNode list1 = lists[0];
        ListNode list2 = lists[1];


        while(list1 != null && list2 != null){
            if(list1.val != list2.val){
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }

        return true;
    }



    private ListNode[] split(ListNode head){

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        boolean even = true;


        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // fast is at the tail or null;

        if(fast == null) {
            even = false;
        }

        ListNode[] lists = new ListNode[2];
        lists[1] = slow.next;
        slow.next = null;

        lists[0] = reverse(head);
        if(!even){
            // if not even number, remove the first one from the first list
            lists[0] = lists[0].next;
        }
        return lists;
    }



    private ListNode reverse(ListNode head){


        if(head == null || head.next == null){
            return head;
        }


        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode c = head;

        while(c != null){
            ListNode next = c.next;
            if(c == head){
                c.next = null;
            } else {
                c.next = p.next;
            }
            p.next = c;
            c = next;
        }

        return dummy.next;
    }
}
