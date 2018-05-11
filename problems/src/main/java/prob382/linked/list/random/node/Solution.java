package prob382.linked.list.random.node;

import utils.list.ListNode;

import java.util.Random;

/**
 * Created by yanya04 on 9/12/2017.
 * Modified by yanya04 on 5/11/2018.
 */

public class Solution {

    ListNode head;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = head, res = head;
        int count = 0;
        Random rand = new Random();
        while(cur != null){
            if(rand.nextInt(++count) == 0){
                res = cur;
            }
            cur = cur.next;
        }
        return res.val;
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(head);
 * int param_1 = obj.getRandom();
 */