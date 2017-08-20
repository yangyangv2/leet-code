package prob463.island.perimeter;

/**
 * Created by yanya04 on 8/19/2017.
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {

        int primeter = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[i].length; j ++){
                if(grid[i][j] == 1){
                    primeter += getAjasentSum(grid, i, j);
                }
            }
        }
        return primeter;
    }

    private int getAjasentSum(int[][] grid, int i, int j){

        int sum = 4;

        int m = grid.length;
        int n = grid[0].length;

        if(i == 0){
            if(grid.length > 1){
                sum -= grid[i + 1][j];
            }
        } else if(i == m - 1){
            sum -= grid[i - 1][j];
        } else {
            sum -= grid[i - 1][j];
            sum -= grid[i + 1][j];
        }

        if(j == 0){
            if(grid[i].length > 1){
                sum -= grid[i][j + 1];
            }
        } else if(j == n - 1){
            sum -= grid[i][j - 1];
        } else {
            sum -= grid[i][j + 1];
            sum -= grid[i][j - 1];
        }
        return sum;
    }
}
