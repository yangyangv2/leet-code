package prob361.bomb.enemy;

/**
 *  Created by yanya04 on 5/25/2018.
 */
public class Solution {

    /*
        the idea is to re-use the earlier calculations
    */
    public int maxKilledEnemies(char[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length, n = grid[0].length;
        int max = 0;

        int rowkills = 0;
        int[] colkills = new int[n];

        for(int i = 0; i < m; i ++){
            rowkills = 0;
            for(int j = 0; j < n; j ++){
                if(grid[i][j] == 'W') continue;

                if(j == 0 || grid[i][j - 1] == 'W'){
                    // recalculate rowkills
                    rowkills = rowkills(grid, i, j);
                }

                if(i == 0 || grid[i - 1][j] == 'W'){
                    // re-calculate colkills
                    colkills[j] = colkills(grid, i, j);
                }
                if(grid[i][j] == '0'){
                    max = Math.max(max, rowkills + colkills[j]);
                }
            }
        }
        return max;
    }

    private int rowkills(char[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        int count = 0;
        while(j < n && grid[i][j] != 'W'){
            if(grid[i][j] == 'E') count ++;
            j ++;
        }
        return count;
    }

    private int colkills(char[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        int count = 0;
        while(i < m && grid[i][j] != 'W'){
            if(grid[i][j] == 'E') count ++;
            i ++;
        }
        return count;
    }
}