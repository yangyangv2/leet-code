package prob778.swim.in.rising.water;

import java.util.PriorityQueue;

/**
 *  Created by yanya04 on 5/25/2018.
 */
public class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        queue.offer(new int[]{0, 0, grid[0][0]});
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int max = pos[2];
            for(int[] dir: dirs){
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];
                if(x < 0 || x == m || y < 0 || y == n || visited[x][y])
                    continue;
                visited[x][y] = true;
                int elevation = Math.max(max, grid[x][y]);
                queue.offer(new int[]{x, y, elevation});

                if(x == m - 1 && y == n - 1)
                    return elevation;
            }
        }
        return -1;

    }
}