package prob347.top.k.frequent.elements;

import java.util.*;

/**
 * Created by yanya04 on 3/18/2018.
 * Modified by yanya04 on 5/2/2018.
 * Modified by yanya04 on 5/8/2018.
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            pq.offer(entry);
            if(pq.size() == k + 1)
                pq.poll();
        }

        while(!pq.isEmpty()) res.add(pq.poll().getKey());
        Collections.reverse(res);
        return res;
    }
}
