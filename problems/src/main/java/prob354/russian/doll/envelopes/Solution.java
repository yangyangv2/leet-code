package prob354.russian.doll.envelopes;

import java.util.Arrays;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        int n = envelopes.length;
        // width        // height
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int[] minheight = new int[n];

        int level = 0, height = 0, index = 0;
        for(int i = 0; i < n; i ++){
            height = envelopes[i][1];
            index = Arrays.binarySearch(minheight, 0, level, height);
            if(index < 0) index = -(index + 1);
            if(index == level) level ++;
            minheight[index] = height;
        }
        return level;
    }
}