package prob499.the.maze.iii;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    // {"u","r","d","l"};
    //{{-1,0},{0,1},{1,0},{0,-1}};
    // r       d       u       l
    private final int[][] dirs = new int[][]{{0, 1},{1, 0},{-1, 0},{0, -1}};
    private final String[] paths = new String[]{"r", "d", "u", "l"};

    private static class Step{

        private Step(int x, int y, int z, String path){
            this.x = x;
            this.y = y;
            this.z = z;
            this.path = path;
        }

        private int x;
        private int y;
        private int z;
        private String path;
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {

        if(maze == null || maze.length == 0) return "impossible";

        // using bfs

        int m = maze.length, n = maze[0].length;

        Step[][] visits = new Step[m][n];

        for(int i = 0; i < m * n; i ++)
            visits[i / n][i % n] = new Step(i/n, i%n, Integer.MAX_VALUE, "");

        Deque<Step> queue = new ArrayDeque<>();
        queue.offer(new Step(ball[0], ball[1], 0, ""));

        while(! queue.isEmpty()){

            Step current = queue.poll();
            int x = current.x, y = current.y, z = current.z;
            String path = current.path;

            Step visit = visits[x][y];

            if(z == visit.z){
                if(visit.path.compareTo(path) <= 0){
                    continue;
                }
            } else if(z > visit.z){
                continue;
            }

            visits[x][y] = current;

            for(int i = 0; i < dirs.length; i ++){
                int[] dir = dirs[i];
                int x1 = x, y1 = y, z1 = z;
                while(x1 > -1 && x1 < m && y1 > -1 && y1 < n && maze[x1][y1] == 0 && (x1 != hole[0] || y1 != hole[1])){
                    x1 += dir[0];
                    y1 += dir[1];
                    z1 ++;
                }

                if(x1 != hole[0] || y1 != hole[1]){
                    x1 -= dir[0];
                    y1 -= dir[1];
                    z1 --;
                }
                // x1, y1 is either at turning spot or at the hole;
                queue.offer(new Step(x1, y1, z1, path + paths[i]));
            }
        }

        if(visits[hole[0]][hole[1]].z == Integer.MAX_VALUE) return "impossible";
        else return visits[hole[0]][hole[1]].path;
    }
}