package prob803.bricks.falling.when.hit;

/**
 *  Created by yanya04 on 5/25/2018.
 */
public class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length, n = grid[0].length;
        int c = hits.length, x = 0, y = 0;

        //Mark whether there is a brick at the each hit
        for(int[] h: hits){
            x = h[0]; y = h[1];
            if (grid[x][y] == 1) grid[x][y] = 0;
            else grid[x][y] = -1;
        }

        //Mark all root bricks as value 2 after all hits, no counting
        for(int i = 0; i < n; i++)
            dfs(0, i, grid);

        //Reversely add the block of each hit back and get count of saved bricks
        int[] ret = new int[c];
        for(int i = c-1; i >= 0; i--) {
            x = hits[i][0]; y = hits[i][1];
            if(grid[x][y] == -1) continue; //This brick is originally empty
            grid[x][y] = 1; //Bring this brick back
            if(!isConnected2Solid(x, y, grid)) continue;
            ret[i] = dfs(x, y, grid)-1;
        }

        return ret;
    }

    //Connect unconnected bricks and mark visited bricks as value 2
    //Return how many extra bricks will be saved bacause of adding (i, j) back, including (i, j) itself
    private int dfs(int i, int j, int[][] grid){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1)
            return 0;
        int ret = 1;
        grid[i][j] = 2;
        ret += dfs(i-1, j, grid);
        ret += dfs(i+1, j, grid);
        ret += dfs(i, j-1, grid);
        ret += dfs(i, j+1, grid);
        return ret;
    }

    private boolean isSolid(int i, int j, int[][] grid){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return false;
        return grid[i][j] == 2;
    }

    //Check whether (i, j) is connected to top
    private boolean isConnected2Solid(int i, int j, int[][] grid){

        // Check if adjacent bricks are not falling or (i, j) itself is on the top
        if (isSolid(i, j + 1, grid)
                || isSolid(i, j - 1, grid)
                || isSolid(i + 1, j, grid)
                || isSolid(i - 1, j, grid)
                || (i == 0)) return true;
        return false;
    }
}