package prob278.first.bad.version;

/**
 * Created by yanya04 on 8/13/2017.
 * Modified by yanya04 on 5/20/2018.
 */
public class Solution {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n, mid = 0;

        while(lo < hi){

            mid = lo + (hi - lo) / 2;
            if(isBadVersion(mid)){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean isBadVersion(int version){
        return true;
    }
}
