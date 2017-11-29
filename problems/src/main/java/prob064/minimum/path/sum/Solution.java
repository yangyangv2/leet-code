package prob064.minimum.path.sum;

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid[0].length == 0) return 0;

        int m = grid.length, n = grid[0].length;

        // setup: min[i][j] = min path to the point [i][j]
        int[][] min = new int[m][n];

        // init
        min[0][0] = grid[0][0];
        for(int i = 1; i < m; i ++)
            min[i][0] = min[i - 1][0] + grid[i][0];
        for(int i = 1; i < n; i ++)
            min[0][i] = min[0][i - 1] + grid[0][i];

        // calculate

        for(int i = 1; i < m; i ++)
            for(int j = 1; j < n; j ++)
                min[i][j] = Math.min(min[i - 1][j], min[i][j - 1]) + grid[i][j];


        return min[m - 1][n - 1];

    }
}