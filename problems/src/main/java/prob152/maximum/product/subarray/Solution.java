package prob152.maximum.product.subarray;

import static java.lang.Math.*;

/**
 *  Modified by yanya04 on 5/14/2018.
 */
public class Solution {

    /*
        if there is no zero ...
        the max or min will be the product of the entire array
        if zero presents, the max or min will be (.A.) 0 (.B.)

        if negative sign is seen, max become min, min becomes max

    */
    public int maxProduct(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length, max = nums[0], min = nums[0], temp = 0, res = nums[0];

        for(int i = 1; i < n; i ++) {
            if(nums[i] < 0){
                temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            res = Math.max(res, max);
        }

        return res;
    }

}