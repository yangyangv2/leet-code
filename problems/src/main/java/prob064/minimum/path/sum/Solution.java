package prob064.minimum.path.sum;

/**
 *  Modified by yanya04 on 5/25/2018.
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] sum = new int[m][n];
        for(int i = 0; i < n; i ++){
            sum[0][i] = grid[0][i];
            if(i > 0) sum[0][i] += sum[0][i - 1];
        }
        for(int i = 0; i < m; i ++){
            sum[i][0] = grid[i][0];
            if(i > 0) sum[i][0] += sum[i - 1][0];
        }

        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                sum[i][j] = grid[i][j] + Math.min(sum[i][j - 1], sum[i - 1][j]);
            }
        }

        return sum[m - 1][n - 1];
    }
}