package prob003.longest.substring.without.repeating.characters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanya04 on 7/22/2017.
 * Modified by yanya04 on 5/6/2018.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int left = 0, right = 0, idx1 = 0, idx2 = 0, max = 0;
        int[] stats = new int[128];
        while(right < s.length()){
            idx1 = (int) s.charAt(right ++);
            stats[idx1] ++;
            while(stats[idx1] > 1){
                idx2 = (int) s.charAt(left ++);
                stats[idx2] --;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}