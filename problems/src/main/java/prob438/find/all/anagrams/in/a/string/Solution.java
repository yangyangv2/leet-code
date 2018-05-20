package prob438.find.all.anagrams.in.a.string;

import java.util.ArrayList;
import java.util.List;

/**
 *  Created by yanya04 on 5/20/2018.
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int[] map = new int[128];
        int count = 0;
        for(int i = 0; i < p.length(); i ++){
            map[(int)p.charAt(i)] ++;
            count ++;
        }

        int start = 0, end = 0;
        List<Integer> res = new ArrayList<>();
        while(end < s.length()){
            if(map[s.charAt(end ++)] -- > 0) count --;
            while(count == 0){
                if(end - start == p.length()){
                    res.add(start);
                }
                if(++map[s.charAt(start ++)] > 0){
                    count ++;
                }
            }
        }
        return res;
    }
}