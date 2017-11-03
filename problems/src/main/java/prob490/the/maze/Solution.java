package prob490.the.maze;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    /*
        BFS
    */

    private final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        if(maze == null || maze.length == 0) return false;

        int m = maze.length, n = maze[0].length;
        boolean[][] visit = new boolean[m][n];

        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(start);
        visit[start[0]][start[1]] = true;

        while(!queue.isEmpty()){

            int[] next = queue.poll();

            int x = next[0], y = next[1];

            // pick a direction
            for(int[] dir: dirs){

                int x1 = x, y1 = y;

                // roll

                while(true){
                    x1 += dir[0];
                    y1 += dir[1];
                    // hit
                    if(x1 < 0 || x1 > m - 1 || y1 < 0 || y1 > n - 1)
                        break;
                    if(maze[x1][y1] != 0)
                        break;
                }
                // step back
                x1 -= dir[0];
                y1 -= dir[1];

                if(visit[x1][y1]) continue;
                visit[x1][y1] = true;
                if(x1 == destination[0] && y1 == destination[1]) return true;
                queue.offer(new int[]{x1, y1});
            }
        }
        return false;
    }
}
