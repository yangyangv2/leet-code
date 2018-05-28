package prob312.burst.balloons;

/**
 * Created by yanya04 on 3/5/2018.
 * Modified by yanya04 on 5/8/2018.
 * Modified by yanay04 on 5/27/2018.
 */
public class Solution {
    public int maxCoins(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int[] scores = new int[n + 2];
        System.arraycopy(nums, 0, scores, 1, n);
        scores[0] = scores[n + 1] = 1;
        int[][] f = new int[n + 1][n + 1];
        return getScore(f, scores, 1, n);
    }

    private int getScore(int[][] f, int[] scores, int lo, int hi){
        int max = 0, temp = 0;
        if(lo > hi) return 0;
        if(f[lo][hi] > 0) return f[lo][hi];
        for(int i = lo; i <= hi; i ++){
            int left = getScore(f, scores, lo, i - 1);
            int right = getScore(f, scores, i + 1, hi);
            temp = left + right + scores[lo - 1] * scores[i] * scores[hi + 1];
            max = Math.max(temp, max);
        }
        f[lo][hi] = max;
        return max;
    }

}