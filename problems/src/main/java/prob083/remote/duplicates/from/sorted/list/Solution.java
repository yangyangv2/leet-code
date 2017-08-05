package prob083.remote.duplicates.from.sorted.list;


import utils.list.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;

        ListNode dummy = head;

        while(dummy.next != null){
            if(dummy.val == dummy.next.val){
                dummy.next = dummy.next.next;
            } else {
                dummy = dummy.next;
            }
        }

        return head;
    }
}