package prob160.intersection.of.two.linked.lists;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/8/2017.
 * Modified by yanya04 on 5/14/2018.
 */
public class Solution {

    private int len(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count ++;
        }
        return count;
    }

    private ListNode shift(ListNode head, int len){

        while(head!= null && len -- > 0){
            head = head.next;
        }
        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = len(headA), len2 = len(headB);
        int diff = Math.abs(len1 - len2);

        if(len1 > len2){
            headA = shift(headA, diff);
        } else {
            headB = shift(headB, diff);
        }

        while(headA != null && headB != null){
            if(headA == headB)
                return headA;

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}