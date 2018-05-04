package prob347.top.k.frequent.elements;

import java.util.*;

/**
 * Created by yanya04 on 3/18/2018.
 * Modified by yanya04 on 5/2/2018.
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num: nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()){
            pq.offer(entry);
        }
        List<Integer> res = new ArrayList<>();
        while(k > 0 && !pq.isEmpty()){
            res.add(pq.poll().getKey());
            k --;
        }
        return res;
    }
}
