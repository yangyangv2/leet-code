package prob523.continuous.subarray.sum;

/**
 * Created by yanya04 on 9/10/2017.
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // brute force

        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i = 1; i < nums.length; i ++){
            sums[i] = sums[i - 1] + nums[i];
        }

        for(int i = 0; i < sums.length; i ++){

            if(i > 0 ){                         // at least 2 nums
                if (k == 0) {                   // if k == 0
                    if(sums[i] == 0){           // if sum == 0, true
                        return true;
                    }
                }
                else if (sums[i] % k == 0){
                    return true;
                }
            }

            for(int j = i + 2; j < sums.length; j ++){  // at least 2 nums
                if(k == 0){                             // if k == 0
                    if(sums[j] - sums[i] == 0){         // if sum == 0, true
                        return true;
                    }

                } else if ((sums[j] - sums[i]) % k == 0){
                    return true;
                }
            }
        }

        return false;
    }
}
