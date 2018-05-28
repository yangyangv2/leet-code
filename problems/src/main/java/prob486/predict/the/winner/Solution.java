package prob486.predict.the.winner;

/*
    Created by yanya04 on 5/27/2018.
 */
public class Solution {
    public boolean PredictTheWinner(int[] nums) {

        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int max = getMax(nums, 0, nums.length - 1);

        return max >= sum - max;
    }
    private int getMax(int[] nums, int start, int end){
        if(start > end)
            return 0;
        return Math.max( nums[start] + getMin(nums, start + 1, end),
                nums[end] + getMin(nums, start, end - 1));
    }

    private int getMin(int[] nums, int start, int end) {
        if(start > end)
            return 0;
        return Math.min(getMax(nums, start + 1, end),
                getMax(nums, start, end - 1));
    }
}