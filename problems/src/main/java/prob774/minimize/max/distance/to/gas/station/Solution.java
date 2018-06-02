package prob774.minimize.max.distance.to.gas.station;

/**
 * Created by yanya04 on 5/11/2018.
 * Modified by yanya04 on 5/22/2018.
 * Modified by yanya04 on 6/1/2018.
 */
public class Solution {
    /*
        avg dist = (s[N-1] - S[0]) / (N - 1 + K)

        avg dist is between 0 and s[N-1] - S[0]

        use trial and error


        k = 5

                     |      |       |       |             |
        |------|-----------------------------------|-----------|
        s1     s2                                  s3          s4

    */
    public double minmaxGasDist(int[] stations, int k) {
        int n = stations.length;
        double lo = 0, hi = stations[n - 1] - stations[0], mid = 0;
        while(lo + 1e-6 < hi){
            mid = lo + (hi - lo) / 2;

            int count = 0;
            for(int i = 1; i < n; i ++)
                count += Math.ceil((stations[i] - stations[i - 1]) / mid) - 1;

            if(count > k){
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;

    }
}