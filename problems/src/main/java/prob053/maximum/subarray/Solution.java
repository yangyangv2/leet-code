package prob053.maximum.subarray;

public class Solution {
    public int maxSubArray(int[] nums) {

        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;

        int n = nums.length;

        int[] maxs = new int[n];

        maxs[0] = nums[0];

        int max = maxs[0];

        for(int i = 1; i < nums.length; i ++){
            maxs[i] = Math.max(maxs[i - 1] + nums[i], nums[i]);
            max = Math.max(max, maxs[i]);
        }
        return max;
    }
}