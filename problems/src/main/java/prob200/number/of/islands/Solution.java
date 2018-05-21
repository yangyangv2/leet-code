package prob200.number.of.islands;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by yanya04 on 10/22/2017.
 * Modified by yanya04 on 3/12/2018.
 * Modified by yanya04 on 5/5/2018.
 * Modified by yanya04 on 5/21/2018.
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfs(grid,i,j);
                    count++;
                }
            }
        return count;
    }
    private void bfs(char[][] grid,int x, int y){
        grid[x][y]='0';
        int n = grid.length, m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while(!queue.isEmpty())
        {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];

            if(i > 0 && grid[i-1][j]=='1')
            {
                queue.offer(new int[]{i - 1, j});
                grid[i-1][j]='0';
            }
            if(i < n - 1 && grid[i+1][j]=='1')  //down
            {
                queue.offer(new int[]{i + 1, j});
                grid[i+1][j]='0';
            }
            if(j > 0 && grid[i][j-1]=='1')  //left
            {
                queue.offer(new int[]{i, j - 1});
                grid[i][j-1]='0';
            }
            if(j<m-1 && grid[i][j+1]=='1')  //right
            {
                queue.offer(new int[]{i, j + 1});
                grid[i][j+1]='0';
            }
        }
    }
}