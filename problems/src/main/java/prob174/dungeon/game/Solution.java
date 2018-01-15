package prob174.dungeon.game;
import static java.lang.Math.*;
/**
 * Created by yanya04 on 1/15/2018.
 */
public class Solution {

    /*
        dp[i][j]: remaining life at (i, j)

        reverse direction, staring from the ending point (P)

        at dp[m - 1][n - 1], it must have life 1. therefore, it's max(1, x - dungen[m - 1][n - 1])


    */
    public int calculateMinimumHP(int[][] dungeon) {

        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            return 0;
        int m = dungeon.length, n = dungeon[0].length;

        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = max(1 - dungeon[m - 1][n - 1], 1);
        for(int i = m - 2; i >= 0; i --){
            dp[i][n - 1] = max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        for(int j = n - 2; j >= 0; j --){
            dp[m - 1][j] = max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        for(int i = m - 2; i >= 0; i --)
            for(int j = n - 2; j >= 0; j --){
                int down = max(dp[i + 1][j] - dungeon[i][j], 1);
                int right = max(dp[i][j + 1] - dungeon[i][j], 1);
                dp[i][j] = min(down, right);
            }

        return dp[0][0];
    }
}