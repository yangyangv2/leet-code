package prob003.longest.substring.without.repeating.characters;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanya04 on 7/22/2017.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        assert solution.lengthOfLongestSubstring("abcabcbb") == 3;
        assert solution.lengthOfLongestSubstring("b") == 1;
        assert solution.lengthOfLongestSubstring("pwwkew") == 3;

    }

    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0) return 0;

        Set<Character> set = new HashSet<>();
        int max = -1;
        // i = start, j = end, check characters between [i, j] are unique
        for(int i = 0, j = 0; j < s.length(); j ++){
            if(set.contains(s.charAt(j))){
                // if char found in from the history
                // clean up chars up to the duplicated char
                while(i < j && s.charAt(i) != s.charAt(j) ){
                    set.remove(s.charAt(i));
                    i ++;
                }
                i ++;
            } else {
                // if no duplicate from history, add to set
                set.add(s.charAt(j));
                max = Math.max(max, set.size());
            }
        }
        return max;
    }
}
