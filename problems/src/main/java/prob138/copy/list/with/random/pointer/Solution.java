package prob138.copy.list.with.random.pointer;

import utils.list.RandomListNode;

/**
 * Created by yanya04 on 8/7/2017.
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {

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