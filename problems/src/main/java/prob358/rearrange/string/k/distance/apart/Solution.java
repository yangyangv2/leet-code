package prob358.rearrange.string.k.distance.apart;

import java.util.*;

/**
 * Created by yanya04 on 9/9/2017.
 */

class Solution {

/*
    map<char, count>
    pq<Entry<Character, Count>>
*/

    public String rearrangeString(String s, int k) {

        int[] map = new int[128];
        for(char c: s.toCharArray()){
            map[c] ++;
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq =
                new PriorityQueue<Map.Entry<Character, Integer>>(
                        (item1, item2) -> { return item2.getValue() == item1.getValue() ?
                                item2.getKey() - item1.getKey() :
                                item2.getValue() - item1.getValue(); }
                );

        for(int i = 0; i < map.length; i ++){
            if(map[i] == 0){
                continue;
            }
            pq.add(new AbstractMap.SimpleEntry<Character, Integer>((char)i, map[i]));
        }


        Queue<Map.Entry<Character, Integer>> waitQueue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){

            Map.Entry<Character, Integer> entry = pq.poll();

            sb.append(entry.getKey());

            entry.setValue(entry.getValue() - 1);
            waitQueue.offer(entry);

            if(waitQueue.size() < k){
                continue;
            }

            entry = waitQueue.poll();
            if(entry.getValue() > 0){
                pq.add(entry);
            }
        }


        return sb.length() == s.length() ? sb.toString() : "";
    }
}
