package prob064.minimum.path.sum;

public class Solution {
    /*
        f[i][j] minimum sum up to [i][j]
        f[i][j] = min(f[i - 1][j], f[i][j - 1]) + A[i][j]
    */
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];

        for(int j = 1; j < n; j ++)
            f[0][j] = grid[0][j] + f[0][j - 1];

        for(int i = 1; i < m; i ++){
            f[i%2][0] = grid[i][0] + f[(i - 1)%2][0];
            for(int j = 1; j < n; j ++){
                f[i%2][j] = Math.min(f[i%2][j - 1], f[(i - 1)%2][j]) + grid[i][j];
            }
        }

        return f[(m - 1)%2][n - 1];
    }
}