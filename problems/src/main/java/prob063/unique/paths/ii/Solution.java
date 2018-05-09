package prob063.unique.paths.ii;

/**
 * Modified by yanya04 on 5/7/2018.
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        int[][] f = new int[2][n + 1];

        if(obstacleGrid[0][0] == 0){
            f[0][1] = 1;
        }

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(obstacleGrid[i][j] == 1){
                    f[(i + 1)%2][j + 1] = 0;
                } else {
                    f[(i + 1)%2][j + 1] = f[i%2][j + 1] + f[(i + 1)%2][j];
                }
            }
        }

        return f[m%2][n];
    }
}