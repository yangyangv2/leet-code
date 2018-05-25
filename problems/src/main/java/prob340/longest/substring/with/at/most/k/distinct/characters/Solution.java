package prob340.longest.substring.with.at.most.k.distinct.characters;

/**
 * Modified by yanya04 on 5/6/2018.
 * Modified by yanya04 on 5/24/2018.
 */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0 || s == null || s.length() == 0) return 0;

        int left = 0, right = 0, count = 0, max = 0;
        int[] stats = new int[128];
        while(right < s.length()){

            if(++stats[s.charAt(right ++)] == 1) count ++;

            while(count > k){
                if(--stats[s.charAt(left ++)] == 0) count --;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}