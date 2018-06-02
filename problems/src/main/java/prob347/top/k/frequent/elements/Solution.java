package prob347.top.k.frequent.elements;

import java.util.*;

/**
 * Created by yanya04 on 3/18/2018.
 * Modified by yanya04 on 5/2/2018.
 * Modified by yanya04 on 5/8/2018.
 * Modified by yanya04 on 5/29/2018.
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        // bucket sort
        List<Integer>[] buckets = new List[nums.length + 1];

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(buckets[entry.getValue()] == null){
                buckets[entry.getValue()] = new ArrayList<>();
            }
            buckets[entry.getValue()].add(entry.getKey());
        }

        for(int i = nums.length; i >= 0; i --){
            if(buckets[i] != null && res.size() < k){
                res.addAll(buckets[i]);
            }
        }
        return res;
    }
}