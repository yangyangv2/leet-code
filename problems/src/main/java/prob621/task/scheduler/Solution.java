package prob621.task.scheduler;

/**
 * Created by yanya04 on 9/10/2017.
 * Modified by yanya04 on 5/20/2018.
 */

import java.util.*;

public class Solution {
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();
        for(char c: tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        Queue<Map.Entry<Character, Integer>> wq = new LinkedList<>();

        int cycles = 0, total = tasks.length;
        Map.Entry<Character, Integer> cur = null;

        while(!pq.isEmpty() && total > 0){

            cur = pq.poll();
            cycles ++;
            cur.setValue(cur.getValue() - 1);
            wq.offer(cur);

            // if it is task, and after process, the total tasks is complete
            // then break;
            if(cur.getKey() != '#' && --total == 0) {
                break;
            }

            // if interval is met, poll one item out of the wq
            // if it stil has value add it back to the pq
            if(wq.size() == n + 1) {
                cur = wq.poll();
                if(cur.getValue() > 0){
                    pq.offer(cur);
                }
            }

            // if there is no elements left in the pq, add idle interval
            if(pq.isEmpty()){
                pq.offer(new AbstractMap.SimpleEntry<Character, Integer>('#', 1));
            }
        }
        return cycles;
    }
}
