package prob347.top.k.frequent.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanya04 on 3/18/2018.
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {

        // count map
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int n = nums.length;
        List<Integer>[] bucket = new List[n + 1];

        // bucket sort
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();

            if(bucket[count] == null){
                bucket[count] = new ArrayList<Integer>();
            }
            bucket[count].add(num);
        }

        List<Integer> res = new ArrayList<>();
        for(int i = n; i >= 0 && k > 0; i --){
            if(bucket[i] != null){
                for(int num: bucket[i]){
                    res.add(num);
                    k --;
                    if(k == 0) break;
                }
            }
        }
        return res;
    }
}
