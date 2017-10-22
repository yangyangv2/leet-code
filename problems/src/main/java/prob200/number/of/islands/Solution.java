package prob200.number.of.islands;

/**
 * Created by yanya04 on 10/22/2017.
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int r = 0; r < grid.length; r ++){
            for(int c = 0; c < grid[0].length; c ++){
                if(grid[r][c] == '1'){
                    count ++;
                    clearMark(r, c, grid);
                }
            }
        }
        return count;
    }

    private void clearMark(int r, int c, char[][] grid){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0')
            return;
        grid[r][c] = '0';

        clearMark(r - 1, c, grid);
        clearMark(r, c - 1, grid);
        clearMark(r + 1, c, grid);
        clearMark(r, c + 1, grid);
    }
}
