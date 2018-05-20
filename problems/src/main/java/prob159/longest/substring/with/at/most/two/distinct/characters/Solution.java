package prob159.longest.substring.with.at.most.two.distinct.characters;

import java.util.Arrays;

/**
 * Created by yanya04 on 9/3/2017.
 * Modified by yanya04 on 5/6/2018.
 * Modified by yanya04 on 5/20/2018.
 */
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] stats = new int[128];
        int left = 0, right = 0, max = 0, count = 0;
        while(right < s.length()){

            if(stats[s.charAt(right ++)]++ == 0) count ++;

            while(count > 2){

                if(-- stats[s.charAt(left ++)] == 0 ) count --;
            }
            max = Math.max(right - left, max);
        }
        return max;

    }
}