package prob382.linked.list.random.node;

import utils.list.ListNode;

import java.util.Random;

/**
 * Created by yanya04 on 9/12/2017.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    private ListNode head;
    private Random rand;


    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {

        ListNode cur = head;
        ListNode result = head;
        int n = 0;
        while(cur != null){
            if(rand.nextInt(++ n) == 0) {
                result = cur;
            }
            cur = cur.next;
        }
        return result.val;
    }


}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */