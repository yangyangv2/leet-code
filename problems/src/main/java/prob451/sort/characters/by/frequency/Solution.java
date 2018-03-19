package prob451.sort.characters.by.frequency;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by yanya04 on 3/18/2018.
 */
public class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return solution2(s, map);
    }

    /*
        bucket sort

        Time:   O(n)
        Space:  O(n)
    */
    private String solution2(String s, Map<Character, Integer> map){

        StringBuilder[] strs = new StringBuilder[s.length() + 1];

        for(Map.Entry<Character, Integer> entry: map.entrySet() ){
            int freq = entry.getValue();
            char c = entry.getKey();

            StringBuilder sb = new StringBuilder();
            int count = freq;
            while(count > 0){
                sb.append(c);
                count --;
            }

            if(strs[freq] == null){
                strs[freq] = new StringBuilder();
            }
            strs[freq].append(sb.toString());
        }

        StringBuilder res = new StringBuilder();
        for(int i = s.length(); i >= 0; i --){
            if(strs[i] != null){
                res.append(strs[i].toString());
            }
        }

        return res.toString();
    }



    /*
        prioirty queue solution

        Time:   O(n*log(n))
        Space:  O(n)
    */
    private String solution1(String s, Map<Character, Integer> map){
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>( (e1, e2) -> {
            return e2.getValue() - e1.getValue();
        });
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){

            Map.Entry<Character, Integer> entry = pq.poll();
            int count = entry.getValue();
            char c = entry.getKey();

            while(count > 0){
                sb.append(c);
                count --;
            }

        }
        return sb.toString();
    }
}