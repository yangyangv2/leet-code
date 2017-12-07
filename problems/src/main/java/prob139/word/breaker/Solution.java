package prob139.word.breaker;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] can = new boolean[s.length() + 1];
        can[0] = true;
        Set<String> set = new HashSet<>(wordDict);

        for(int i = 1; i <= s.length(); i ++){
            for(int j = 0; j < i; j ++){
                if(can[j] & set.contains(s.substring(j, i))){
                    can[i] = true;
                    break;
                }
            }
        }

        return can[s.length()];
    }
}