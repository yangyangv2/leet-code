package prob490.the.maze;

import java.util.Queue;
import java.util.LinkedList;

/*
    Modified by yanya04 on 5/31/2018
 */
public class Solution {

    private int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        visited[start[0]][start[1]] = true;

        queue.offer(start);
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for(int[] dir: dirs){
                int x = pos[0], y = pos[1];
                while(true){
                    x += dir[0]; y += dir[1];
                    if(x < 0 || y < 0 || x == m || y == n || maze[x][y] == 1)
                        break;

                }
                x -= dir[0];
                y -= dir[1];

                if(x == destination[0] && y == destination[1])
                    return true;


                if(!visited[x][y]){
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }

        return false;

    }
}
