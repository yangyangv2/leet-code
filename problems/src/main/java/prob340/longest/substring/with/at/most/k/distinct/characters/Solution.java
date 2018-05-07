package prob340.longest.substring.with.at.most.k.distinct.characters;

/**
 * Modified by yanya04 on 5/6/2018.
 */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0 || s == null || s.length() == 0) return 0;

        int left = 0, right = 0, idx1 = 0, idx2 = 0, count = 0, max = 0;
        int[] stats = new int[128];
        while(right < s.length()){
            idx1 = (int) s.charAt(right ++);
            stats[idx1] ++;
            if(stats[idx1] == 1) count ++;

            while(count > k){
                idx2 = (int) s.charAt(left ++);
                stats[idx2] --;
                if(stats[idx2] == 0) count --;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}