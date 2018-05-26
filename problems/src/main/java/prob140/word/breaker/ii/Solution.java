package prob140.word.breaker.ii;

import java.util.*;

/**
 *  Created by yanya04 on 5/25/2018.
 */
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> mem = new HashMap<>();
        return backtrack(s, dict, mem);
    }

    private List<String> backtrack(String s, Set<String> dict, Map<String, List<String>> mem){

        if(s.length() == 0)
            return Collections.emptyList();

        if(mem.containsKey(s))
            return mem.get(s);

        List<String> list = new ArrayList<>();
        String word = null;
        for(int i = 1; i <= s.length(); i ++){
            word = s.substring(0, i );
            if(!dict.contains(word)) continue;
            // only when word is the last one in the sentance
            if(i == s.length()){
                list.add(word);
            } else {
                for(String str: backtrack(s.substring(i), dict, mem)){
                    list.add(word + " " + str);
                }
            }
        }
        mem.put(s, list);
        return list;
    }
}