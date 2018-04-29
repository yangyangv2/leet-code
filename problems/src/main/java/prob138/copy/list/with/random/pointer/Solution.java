package prob138.copy.list.with.random.pointer;

import utils.list.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 8/7/2017.
 * Modified by yanya04 on 4/29/2017
 */
public class Solution {

    /*
        1--->2--->3--->4--->nil
             |         |
             +---------+

        2 passes,

    */
    public RandomListNode copyRandomList(RandomListNode head) {

        // 1st pass
        RandomListNode cur = head, temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = temp;
            cur = temp;
        }

        // 2nd pass
        cur = head;
        while(cur != null){
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        // 3nd pass split
        cur = head;
        RandomListNode res = new RandomListNode(0), last = res;
        while(cur != null){
            last.next = cur.next;
            last = last.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return res.next;

    }
}