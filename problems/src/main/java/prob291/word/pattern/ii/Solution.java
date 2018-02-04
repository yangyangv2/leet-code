package prob291.word.pattern.ii;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yanya04 on 2/3/2018.
 */
public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern == null || str == null)
            return false;

        return backtrack(str, new HashMap<Character, String>(), new HashSet<String>(), pattern);
    }



    private boolean backtrack(String str, Map<Character, String> dict, Set<String> seen, String pattern){

        if(pattern.isEmpty()) return str.isEmpty();
        if(pattern.length() > str.length()) return false;

        char p = pattern.charAt(0);
        if(dict.containsKey(p)){
            String word = dict.get(p);
            if(!str.startsWith(word)) return false;
            return backtrack(str.substring(word.length()), dict, seen, pattern.substring(1));
        } else {
            for(int i = 0; i < str.length(); i ++){
                String word = str.substring(0, i + 1);
                if(seen.contains(word)) continue;
                dict.put(p, word);
                seen.add(word);

                if(backtrack(str.substring(i + 1), dict, seen, pattern.substring(1))) return true;

                dict.remove(p);
                seen.remove(word);
            }

            return false;
        }

    }
}
