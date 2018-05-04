package prob275.h.index.ii;

/**
 * Created by yanya04 on 8/13/2017.
 */
public class Solution {
    /*
    MovingAverage:
       +---------k---------+
       |                   |
a    0 1   2   3   4   5   6
b    0 100 200 300 400 500 600

    find min(b) where b >= k;


*/
    /*
 index  0 1 2 3 4
        4 5 8 9 9

        find minimum value, where value >= (len - index)



    */

    public int hIndex(int[] citations) {

        int n = citations.length;
        int lo = 0, hi = n - 1, mid = 0;
        while(lo <= hi){
            mid = lo + ((hi - lo) >> 1);
            if(citations[mid] < n - mid){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return n - lo;

    }
}
