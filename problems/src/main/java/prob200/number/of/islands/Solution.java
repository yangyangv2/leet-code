package prob200.number.of.islands;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by yanya04 on 10/22/2017.
 * Modified by yanya04 on 3/12/2018.
 * Modified by yanya04 on 5/5/2018.
 * Modified by yanya04 on 5/21/2018.
 * Modified by yanya04 on 6/10/2018.
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length, count = 0;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(grid[i][j] == '1'){
                    count ++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void bfs(char[][] grid, int row, int col){
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = '0';
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            for(int[] dir: dirs){
                int x = pos[0] + dir[0], y = pos[1] + dir[1];
                if(x < 0 || x == m || y < 0 || y == n || grid[x][y] == '0')
                    continue;
                queue.offer(new int[]{x, y});
                grid[x][y] = '0';
            }
        }
    }
}