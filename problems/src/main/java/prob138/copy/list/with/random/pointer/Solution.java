package prob138.copy.list.with.random.pointer;

import utils.list.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 8/7/2017.
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {

        return solution2(head);
    }


/*
        list:

        1->2->3->4->5->6
           |     |
           +-----+

        Solution1 1:

        two pass, with map?

        0. build random hashmap, array, reference to location
        1. copy without random
        2. use location id to retrive node

        space O(n), complexity O(n2)

*/

    private RandomListNode solution1(RandomListNode head) {
        if(head == null) return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;

        while(cur != null){
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;

        while(cur != null){
            if(cur.next != null){
                map.get(cur).next = map.get(cur.next);
            }
            if(cur.random != null){
                map.get(cur).random = map.get(cur.random);
            }
            cur = cur.next;
        }

        return map.get(head);
    }



    /*
            Solution1 2:

            Original

            1->2->3->4->5->6
               |     |
               +-----+

            1. make a copy of the list

            1->(1)->2->(2)->3->(3)->4->(4)->5->(5)->6->(6)
                    |               |
                    +---------------+

            2. make a copy of the random

            1->(1)->2->(2)->3->(3)->4->(4)->5->(5)->6->(6)
                    |   |            |  |
                    +---------------+   |
                        |               |
                        +---------------+

            3. restore the list
    */
    private RandomListNode solution2(RandomListNode head){
        if(head == null) return null;



        RandomListNode iter = head;

        // copy list
        while(iter != null){
            RandomListNode copy = new RandomListNode(iter.label);
            RandomListNode next = iter.next;
            iter.next = copy;
            copy.next = next;
            iter = iter.next.next;
        }

        // copy random
        iter = head;
        while(iter != null){
            if(iter.random != null){
                iter.next.random = iter.random.next;
            }

            iter = iter.next.next;
        }

        //restore the list;

        iter = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode iter2 = dummy;
        while(iter != null){
            iter2.next = iter.next;
            RandomListNode next = iter.next.next;
            iter.next = next;
            iter = next;
            iter2 = iter2.next;
        }
        return dummy.next;
    }
}
