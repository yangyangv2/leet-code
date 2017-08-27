package prob441.arranging.coins;

/**
 * Created by yanya04 on 8/26/2017.
 */
public class Solution {

/*
    sum = n * (n + 1) / 2
*/

    public int arrangeCoins(int n) {

        long lo = 0L, hi = (long) n;

        while(lo <= hi){
            long mid = lo + (hi - lo) / 2;
            if( mid * (mid + 1)  <= n * 2L ){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return (int)(lo - 1);

    }
}
