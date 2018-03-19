package prob692.top.k.frequent.words;

import java.util.*;

/**
 * Created by yanya04 on 3/18/2018.
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        // O(n) count word frequency
        Map<String, Integer> map = new HashMap<>();
        for(String word: words) map.put(word, map.getOrDefault(word, 0) + 1);

        // use priority queue to track each element

        // n * log k
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
            if(e1.getValue() == e2.getValue()){
                return e2.getKey().compareTo(e1.getKey());
            } else {
                return e1.getValue() - e2.getValue();
            }
        });

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }

        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }
}