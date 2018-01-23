package prob256.paint.house;
import static java.lang.Math.*;
/**
 * Created by yanya04 on 1/22/2018.
 */
public class Solution {

    /*
        let dp[i][j] = cost to paint houses till i
        dp[i][0] = min(dp[i - 1][1], dp[i - 1][2])
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2])
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1])
    */
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length < 3)
            return 0;

        int n = costs.length;
        for(int i = 1; i < n; i ++){
            costs[i][0] += min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += min(costs[i - 1][1], costs[i - 1][0]);
        }

        return min(costs[n - 1][0], min(costs[n - 1][1], costs[n - 1][2]));
    }
}