package prob387.first.unique.character.in.a.string;

import java.util.Arrays;

/**
 * Created by yanya04 on 3/17/2018.
 */
public class Solution {
    public int firstUniqChar(String s) {

        int[] occur = new int[26];
        Arrays.fill(occur, -1);
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            int loc = c - 'a';
            count[loc]++;
            if(count[loc] == 1){
                // first occur index;
                occur[loc] = i;
            }
        }

        int minIdx = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i ++){
            if(count[i] == 1 && occur[i] < minIdx){
                minIdx = occur[i];
            }
        }
        return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
    }
}