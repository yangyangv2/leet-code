package prob275.h.index;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/13/2017.
 */
public class Solution {
    /*
    Solution:
       +---------k---------+
       |                   |
a    0 1   2   3   4   5   6
b    0 100 200 300 400 500 600

    find min(b) where b >= k;


*/

    public int hIndex(int[] citations) {

        if(citations == null || citations.length == 0){
            return 0;
        }

        Arrays.sort(citations);

        return findMinB(citations, 0, citations.length - 1);
    }


    private int findMinB(int[] c, int start, int end){

        if(start >= end){
            return Math.min(c[start], c.length - start);
        }

        int mid = start + (end - start) / 2;

        if(c[mid] >= c.length - mid){
            return findMinB(c, start, mid);
        } else {
            return findMinB(c, mid + 1, end);
        }

    }
}
