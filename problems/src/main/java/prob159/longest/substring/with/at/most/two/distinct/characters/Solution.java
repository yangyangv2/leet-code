package prob159.longest.substring.with.at.most.two.distinct.characters;

import java.util.Arrays;

/**
 * Created by yanya04 on 9/3/2017.
 * Modified by yanya04 on 5/6/2018.
 */
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] stats = new int[128];
        int left = 0, right = 0, idx1 = 0, idx2 = 0, max = 0, count = 0;
        while(right < s.length()){
            idx1 = (int) s.charAt(right ++);

            if(stats[idx1] == 0) count ++;

            stats[idx1]++;

            while(count > 2){
                idx2 = (int) s.charAt(left ++);
                stats[idx2] --;
                if(stats[idx2] == 0 ) count --;
            }
            max = Math.max(right - left, max);
        }
        return max;

    }
}