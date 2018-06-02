package prob692.top.k.frequent.words;

import java.util.*;

/**
 * Created by yanya04 on 3/18/2018.
 * Modified by yanya04 on 5/29/2018.
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        // O(n) count word frequency
        Map<String, Integer> map = new HashMap<>();
        for(String word: words) map.put(word, map.getOrDefault(word, 0) + 1);

        // use priority queue to track each element


        // bucket sort

        TreeSet<String>[] buckets = new TreeSet[words.length + 1];

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            int index = entry.getValue();
            String word  = entry.getKey();
            if(buckets[index] == null){
                buckets[index] = new TreeSet<String>();
            }
            buckets[index].add(word);
        }

        List<String> res = new ArrayList<>();

        for(int i = words.length; i >= 0; i --){
            if(buckets[i] != null){
                res.addAll(buckets[i]);
            }
            if(res.size() == k) break;
            else if(res.size() > k){
                while(res.size() > k){
                    res.remove(res.size() - 1);
                }
                break;
            }
        }

        return res;
    }
}