package prob290.word.pattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yanya04 on 2/3/2018.
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(str == null || pattern == null)
            return false;

        Map<Character, String> dict = new HashMap<>();
        Set<String> seen = new HashSet<>();
        String[] words = str.split(" ");

        if(words.length != pattern.length())
            return false;

        for(int i = 0; i < pattern.length(); i ++){
            char p = pattern.charAt(i);
            String word = words[i];
            if(!dict.containsKey(p)){
                if(seen.contains(word))
                    return false;
                else {
                    dict.put(p, word);
                    seen.add(word);
                }
            } else if(!dict.get(p).equals(word))
                return false;
        }
        return true;
    }
}