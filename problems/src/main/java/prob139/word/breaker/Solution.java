package prob139.word.breaker;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  Modifed by yanya04 On 4/26/2018
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return solve(s, dict);
    }

    private boolean solve(String s, Set<String> dict){

        int len = s.length();
        boolean[] can = new boolean[len + 1];
        can[0] = true;  // if there's 0 char, it can be broken
        for(int end = 1; end <= len; end ++){
            for(int start = 0; start < end; start ++){
                can[end] = can[start] && dict.contains(s.substring(start, end));
                if(can[end]) break;
            }
        }
        return can[len];
    }


    private boolean backtrack(String s, Set<String> dict){

        if(s.length() == 0) return true;

        String left = null, right = null;
        for(int i = 1; i <= s.length(); i ++){
            left = s.substring(0, i);
            if(dict.contains(left)){
                right = s.substring(i);
                if(backtrack(right, dict)){
                    return true;
                }
            }
        }
        return false;
    }
}