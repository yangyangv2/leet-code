package prob358.rearrange.string.k.distance.apart;

import java.util.*;

/**
 * Created by yanya04 on 9/9/2017.
 * Modified by yanya04 on 5/20/2018.
 * Modified by yanya04 on 6/2/2018.
 */

public class Solution {
    /*
        task scheduling problem

        1. make frequency stats
        2. use priority queue + (task) queue

    */
    public String rearrangeString(String s, int k) {

        if(k == 0) return s;

        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        // queue is used to maintain the distance
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        Map.Entry<Character, Integer> cur = null;

        while(!pq.isEmpty()){

            cur = pq.poll();
            cur.setValue(cur.getValue() - 1);
            queue.offer(cur);
            sb.append(cur.getKey());

            if(queue.size() == k){
                cur = queue.poll();
                if(cur.getValue() > 0){
                    pq.offer(cur);
                }
            }
        }

        return sb.length() == s.length() ? sb.toString() : "";

    }
}
