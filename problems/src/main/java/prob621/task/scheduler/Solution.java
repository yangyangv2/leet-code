package prob621.task.scheduler;

/**
 * Created by yanya04 on 9/10/2017.
 */

import java.util.*;

public class Solution {

/*
    ['A','A','A','B']
    3

pq  [A:3, B:3]
wq  [A:2, B:0, X, X]

    A B X X A X X X A


    ['A','A','A','A','A','A','B','C','D','E','F','G']
    2

    A B C A D E A F G A X X A X X A

*/


    public int leastInterval(char[] tasks, int n) {

        int[] map = new int[128];
        for(char c : tasks){
            map[c] ++;
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>(
                (item1, item2) -> {
                    return (item1.getValue() == item2.getValue()) ?
                            item2.getKey() - item1.getKey():
                            item2.getValue() - item1.getValue();
                }
        );

        for(int i = 0; i < map.length; i ++){
            if(map[i] == 0) continue;
            pq.add(new AbstractMap.SimpleEntry((char) i, map[i]));
        }

        int k = 0;

        Queue<Map.Entry<Character, Integer>> waitQueue = new ArrayDeque<>();
        while(!pq.isEmpty()){

            Map.Entry<Character, Integer> entry = pq.poll();
            entry.setValue(entry.getValue() - 1);
            waitQueue.add(entry);
            k++;

            if(waitQueue.size() == n + 1){
                // waitQueue is full
                while(!waitQueue.isEmpty()){
                    entry = waitQueue.poll();
                    if(entry.getValue() > 0){
                        pq.add(entry);
                    }
                }
            } else {
                // waitQueue is not full
                if(!pq.isEmpty()){
                    // get next char
                    continue;
                }

                // add idles
                int idles = n + 1 - waitQueue.size();

                while(!waitQueue.isEmpty()){
                    entry = waitQueue.poll();
                    if(entry.getValue() > 0){
                        pq.add(entry);
                    }
                }
                if(!pq.isEmpty()){
                    // only add idles if there's a next node
                    k += idles;
                }
            }
        }

        return k;
    }
}
