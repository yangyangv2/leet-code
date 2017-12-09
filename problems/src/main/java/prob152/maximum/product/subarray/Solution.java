package prob152.maximum.product.subarray;

import static java.lang.Math.*;

public class Solution {

    public int maxProduct(int[] nums) {

        int n = nums.length;
        if(n == 0) return 0;

        int max = nums[0], min = nums[0], res = nums[0];

        for(int i = 1; i < n; i ++){
            // negative
            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }

            max = max(nums[i], max * nums[i]);
            min = min(nums[i], min * nums[i]);

            res = max(max(max, min), res);

        }
        return res;
    }
}