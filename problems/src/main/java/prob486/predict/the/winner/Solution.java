package prob486.predict.the.winner;

/*
    Created by yanya04 on 5/27/2018.
    Modified by yanya04 on 6/1/2018.
 */
public class Solution {

    // max[i, j] => max(i + min(i + 1, j), j + min(i, j - 1))
    // min[i, j] => min(i, max(i + 1, j), j + max(i, j - 1))

    public boolean PredictTheWinner(int[] nums) {
        int sum = 0, n = nums.length;
        for(int num: nums) sum += num;

        int[][] mMax = new int[n][n], mMin = new int[n][n];
        int max = getMax(nums, 0, nums.length - 1, mMax, mMin);
        return max >= sum - max;
    }

    private int getMax(int[] nums, int s, int e, int[][] mMax, int[][] mMin){
        if(s > e) return 0;
        if(mMax[s][e] > 0) return mMax[s][e];

        mMax[s][e] = Math.max(nums[s] + getMin(nums, s + 1, e, mMax, mMin), nums[e] + getMin(nums, s, e - 1, mMax, mMin));

        return mMax[s][e];
    }

    private int getMin(int[] nums, int s, int e, int[][] mMax, int[][] mMin){
        if(s > e) return 0;
        if(mMin[s][e] > 0) return mMin[s][e];

        mMin[s][e] = Math.min(getMax(nums, s + 1, e, mMax, mMin), getMax(nums, s, e - 1, mMax, mMin));

        return mMin[s][e];

    }
}