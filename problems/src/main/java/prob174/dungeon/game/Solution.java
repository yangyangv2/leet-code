package prob174.dungeon.game;
import static java.lang.Math.*;
/**
 * Created by yanya04 on 1/15/2018.
 * Modified by yanya04 on 5/16/2018.
 */
public class Solution {

    // start from the end
    // 1. at any point, the life should be at least 1
    // 2. minimize the life

    // dp[i][j] = life at (i, j)
    // dp[i][j] = Math.min( Math.max(dp[i - 1][j] - dungeon[i][j], 1) , Math.max(dp[i][j - 1] - dungeon[i][j], 1))


    // dp[i] = max(dp[i - 1] + 5, 1)
    //   1
    //  +3
    //  -5
    public int calculateMinimumHP(int[][] dungeon) {

        if(dungeon == null || dungeon.length == 0) return 0;
        int m = dungeon.length, n = dungeon[0].length;
        int[][] life = new int[m][n];
        life[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        for(int i = m - 2; i >= 0; i --){
            life[i][n - 1] = Math.max(life[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        for(int i = n - 2; i >= 0; i --){
            life[m - 1][i] = Math.max(life[m - 1][i + 1] - dungeon[m - 1][i], 1);
        }

        for(int i = m - 2; i >= 0; i --){
            for(int j = n - 2; j >= 0; j --){
                life[i][j] = Math.min(
                        Math.max(life[i + 1][j] - dungeon[i][j], 1),
                        Math.max(life[i][j + 1] - dungeon[i][j], 1)
                );
            }
        }
        return life[0][0];

    }
}