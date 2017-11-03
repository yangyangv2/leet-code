package prob505.the.maze.ii;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    private int[][] dirs = new int[][]{{1, 0},{0, 1},{-1, 0},{0, -1}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        if(maze == null || maze.length == 0) return -1;

        int m = maze.length, n = maze[0].length;

        int[][] routes = new int[m][n];
        for(int i = 0; i < m; i ++)
            for(int j = 0; j < n; j ++)
                routes[i][j] = Integer.MAX_VALUE;

        Deque<int[]> queue = new ArrayDeque<>();
        //PriorityQueue<int[]> queue=new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);

        queue.offer(new int[]{start[0], start[1], 0});

        while(!queue.isEmpty()){

            int[] next = queue.poll();
            int x = next[0], y = next[1], z = next[2];

            if(routes[x][y] <= z) continue; // skip if the current path is already larger than shortest
            routes[x][y] = z;
            for(int[] dir: dirs){
                int x1 = x, y1 = y, z1 = z;
                // pick a direction and start rolling
                while(x1 > -1 && x1 < m && y1 > -1 && y1 < n && maze[x1][y1] == 0){
                    x1 += dir[0];
                    y1 += dir[1];
                    z1 ++;
                }
                x1 -= dir[0];
                y1 -= dir[1];
                z1 --;
                // [x1, y1] is the next stop point
                queue.offer(new int[]{x1, y1, z1});
            }
        }

        int path = routes[destination[0]][destination[1]];
        if(path == Integer.MAX_VALUE) return -1;
        else return path;

    }
}