package prob340.longest.substring.with.at.most.k.distinct.characters;

public class Solution {
    /**
     at most k distinct char
     1. need a count to track distinct char
     2. slide window
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null) return 0;

        int[] map = new int[128];
        int count = 0, len = 0, begin = 0, end = 0;
        char[] chars = s.toCharArray();

        while(end < chars.length){

            // when found a new char, increase the count
            if( ++map[chars[end ++]] == 1) {
                count ++;
            }
            // if have more than k distinct chars
            while(count > k){
                // shrink the window and remove one distinct char
                // if after removing this char, the count of this char is 0
                // then it means one distinct char is evicted
                if( --map[chars[begin ++]] == 0){
                    count --;
                }
            }

            // now this window is valid, update the length
            len = Math.max(len, end - begin);
        }

        return len;
    }
}