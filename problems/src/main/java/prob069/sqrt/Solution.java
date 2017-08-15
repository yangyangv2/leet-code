package prob069.sqrt;

/**
 * Created by yanya04 on 8/14/2017.
 */
public class Solution {


/*
    a * a = x
*/

    public int mySqrt(int x) {

        if(x == 0) return 0;

        // lo is 1, skip lo = [0]
        int lo = 1, hi = x;
        while(hi >= lo){
            int mid = lo + (hi - lo) / 2;
            if( mid  < x / mid){
                lo = mid + 1;
            } else if( mid == x / mid){
                return mid;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }
}
