package prob774.minimize.max.distance.to.gas.station;

/**
 * Created by yanya04 on 5/11/2018.
 * Modified by yanya04 on 5/22/2018.
 */
public class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        int n = stations.length, count = 0;
        int total = stations[n - 1] - stations[0];
        double lo = 0, hi = total, mid = 0;

        while(lo < hi && lo + 1e-6 < hi){
            mid = lo + (hi - lo) / 2;
            count = 0;
            for(int i = 0; i < n - 1; i ++){
                count += Math.ceil((stations[i + 1] - stations[i]) / mid) - 1;
            }

            if(count > K){
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}