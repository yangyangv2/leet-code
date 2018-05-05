package prob643.maximum.average.subarray.i;

/**
 * Created by yanya04 on 8/20/2017.
 * Modified by yanya04 on 5/4/2018.
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        return slidewindow(nums, k);
    }

    private double slidewindow(int[] nums, int k){
        if(nums == null || nums.length == 0) return -1;
        int n = nums.length;
        long sum = 0;
        for(int i = 0; i < k; i ++){
            sum += nums[i];
        }

        double res = sum * 1.0 / k;

        for(int i = k; i < n; i ++){
            sum = sum - nums[i - k] + nums[i];
            res = Math.max(res, 1.0 * sum / k);
        }

        return res;
    }

    private double presum(int[] nums, int k){
        if(nums == null || nums.length == 0) return -1;
        int n = nums.length;
        long[] presum = new long[n];
        presum[0] = nums[0];
        for(int i = 1; i < n; i ++){
            presum[i] = nums[i] + presum[i - 1];
        }

        double res = 1.0 * presum[k - 1] / k;
        for(int i = k; i < n; i ++){
            res = Math.max(res, 1.0 * (presum[i] - presum[i - k]) / k);
        }
        return res;
    }
}
