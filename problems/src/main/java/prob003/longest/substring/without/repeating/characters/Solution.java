package prob003.longest.substring.without.repeating.characters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanya04 on 7/22/2017.
 * Modified by yanya04 on 5/6/2018.
 * Modified by yanya04 on 5/25/2018.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int left = 0, right = 0, max = 0;
        int[] stats = new int[128];
        while(right < s.length()){
            stats[s.charAt(right)] ++;
            while( stats[s.charAt(right)]> 1){
                stats[s.charAt(left ++)] --;
            }
            right ++;
            max = Math.max(max, right - left);
        }
        return max;
    }
}