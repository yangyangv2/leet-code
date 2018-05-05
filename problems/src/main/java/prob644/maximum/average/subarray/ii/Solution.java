package prob644.maximum.average.subarray.ii;

/**
 * Created by yanya04 On 5/4/2018.
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double lo = -10000, hi = 10000, mid = 0, acc = 50;
        while(lo < hi && acc -- > 0){
            mid = (lo + hi) / 2;
            if(check(nums, mid, k)){
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    // check if there's a subarray has sum larger than mid
    private boolean check(int[] nums, double mid, int k){
        int n = nums.length;
        double[] vals = new double[n];
        for(int i = 0; i < n; i ++){
            vals[i] = nums[i] - mid;
        }

        double presum = 0;
        double premin = 0;
        double sum = 0;
        for(int i = 0; i < n; i ++){
            sum += vals[i];
            if(i + 1 >= k){
                presum += vals[i - k + 1];
                if(sum - premin > 0) return true;
                premin = Math.min(premin, presum);
            }
        }
        return false;
    }
}