package prob003.longest.substring.without.repeating.characters;

import java.util.Arrays;
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

    /*
        solution:

        1. map
        2. slide window
    */

    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        Arrays.fill(map, 0);
        int i = 0, j = 0, max = Integer.MIN_VALUE;
        while(j < s.length()){
            if(map[s.charAt(j)]++ == 0){
                // no duplicate
                max = Math.max(max, j + 1 - i);

            }
            // with duplicate
            while(map[s.charAt(j)] > 1){
                map[s.charAt(i++)] --;
            }
            j ++;
        }
        max = Math.max(max, j - i);

        return max;

    }
}
