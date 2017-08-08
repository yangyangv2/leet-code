package prob160.intersection.of.two.linked.lists;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/8/2017.
 */
public class Solution {

/*
    1. length the lists
    2. get the common start and find the intersaction
*/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = length(headA);
        int lenB = length(headB);
        int offset = 0;
        if(lenA > lenB){
            while(offset < lenA - lenB){
                offset++;
                headA = headA.next;
            }
        } else {
            while(offset < lenB - lenA){
                offset++;
                headB = headB.next;
            }
        }

        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int length(ListNode node){
        int length = 0;
        ListNode cur = node;
        while(cur != null){
            length ++;
            cur = cur.next;
        }

        return length;
    }

}
