package prob734.sentence.similarity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        Map<String, Set<String>> map = new HashMap<>();
        for(String[] pair : pairs){
            if(!map.containsKey(pair[0])) map.put(pair[0], new HashSet<String>());
            map.get(pair[0]).add(pair[1]);
        }
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        if(words1.length != words2.length) return false;
        for(int i = 0; i < words1.length; i ++){

            if(words1[i].equals(words2[i])) continue;

            if(map.getOrDefault(words1[i], new HashSet<>()).contains(words2[i])) continue;

            if(map.getOrDefault(words2[i], new HashSet<>()).contains(words1[i])) continue;

            return false;

        }
        return true;
    }
}