package prob053.maximum.subarray;

/**
 * Modified by yanya04 On 4/30/2018
 */
public class Solution {

    /*
        Input:  [-2,1,-3,4,-1,2,1,-5,4]
        Sum:     -2 1 -2 4
        max:     -2 1  1
    */
    public int maxSubArray(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    private int divide(int[] nums, int lo, int hi){
        if(lo > hi) return Integer.MIN_VALUE;
        int mid = lo + (hi - lo) / 2;

        int left = divide(nums, lo, mid - 1);
        int right = divide(nums, mid + 1, hi);

        int leftMax = 0, leftSum = 0;
        for(int i = mid - 1; i >= lo; i --){
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        int rightMax = 0, rightSum = 0;
        for(int i = mid + 1; i <= hi; i ++){
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }

        return Math.max(Math.max(left, right), rightMax + leftMax + nums[mid]);
    }

    private int dp(int[] nums){
        int max = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i < nums.length; i ++){
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}