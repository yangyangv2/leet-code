package prob643.maximum.average.subarray.i;

/**
 * Created by yanya04 on 8/20/2017.
 */
public class Solution {

/*
    1. rotating hash (sum)
    3. average

*/

    public double findMaxAverage(int[] nums, int k) {


        int sumLen = nums.length - k + 1;

        int[] sums = new int[sumLen];

        int sum = 0;
        for(int i = 0; i < k; i ++){
            sum += nums[i];
        }
        sums[0] = sum;

        for(int i = 1; i < sumLen; i ++){
            // rotate
            int old = sums[i - 1] - nums[i - 1];
            sums[i] = old + nums[i + k -1];
        }

        double max = Double.NEGATIVE_INFINITY;
        for(int i = 0; i < sums.length; i ++){
            max = Math.max(sums[i] * 1.0 / k, max);
        }

        return max;
    }
}
