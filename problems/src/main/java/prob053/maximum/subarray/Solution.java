package prob053.maximum.subarray;

/**
 * Modified by yanya04 On 4/30/2018
 */
public class Solution {
    /*
            -2  1   -3  4   -1  2   1   -5  4
    sum     -2  1   -2  4   3   5   6   1   5
    max     -2  1    1  4   4   5   6   6   6
    */
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;

        int max = nums[0], sum = nums[0];
        for(int i = 1; i < nums.length; i ++){
            if(sum + nums[i] > nums[i]){
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}