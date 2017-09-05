package prob159.longest.substring.with.at.most.two.distinct.characters;

import java.util.Arrays;

/**
 * Created by yanya04 on 9/3/2017.
 */
public class Solution {
/*
    1. map count
    2. shift j: if map[j] == 0 then len ++
    3. shift i: if map[i--] -- == 1 then len --;
*/

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int[] map = new int[128];
        Arrays.fill(map, 0);

        int i = 0, j = 0, max = Integer.MIN_VALUE, count = 0;

        while(j < s.length()){
            if(map[s.charAt(j++)]++ == 0) count ++;
            // j - i > 2
            if(count <= 2) {
                // valid
                int len = j - i;
                max = Math.max( max, len );
            } else {
                // exceed, move i
                while(count > 2){
                    if(map[s.charAt(i ++)]-- == 1) count --;
                }
            }
        }
        return Integer.MIN_VALUE == max ? 0: max;
    }
}
