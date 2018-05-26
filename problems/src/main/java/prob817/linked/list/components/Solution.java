package prob817.linked.list.components;

import utils.list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 *  Created by yanya04
 */
public class Solution {
    public int numComponents(ListNode head, int[] G) {

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < G.length; i ++){
            set.add(G[i]);
        }

        int component = 0;
        boolean started = false;

        ListNode cur = head;
        while(cur != null){
            if(!started){
                if(set.contains(cur.val)){
                    set.remove(cur.val);
                    component ++;
                    started = true;
                }
            } else {
                if(!set.contains(cur.val)){
                    started = false;
                } else {
                    set.remove(cur.val);
                }
            }
            cur = cur.next;
        }
        return component + set.size();
    }
}