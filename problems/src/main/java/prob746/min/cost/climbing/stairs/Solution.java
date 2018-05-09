package prob746.min.cost.climbing.stairs;

/**
 * Created by yanya04 on 5/8/2018.
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length < 2) return 0;
        int n = cost.length;
        if(n == 2) return Math.min(cost[0], cost[1]);

        int[] f = new int[n];
        f[0] = cost[0];
        f[1] = cost[1];

        for(int i = 2; i < n; i ++){
            f[i] = Math.min(f[i - 1], f[i - 2]) + cost[i];
        }

        return Math.min(f[n - 1], f[n - 2]);

    }
}