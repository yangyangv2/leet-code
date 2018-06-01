package prob499.the.maze.iii;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 *  Modified by yanya04 on 5/31/2018.
 */
public class Solution {

    class Point{
        int x, y, z;
        String path;
        Point(int x, int y, int z, String path){
            this.x = x;
            this.y = y;
            this.z = z;
            this.path = path;
        }
    }

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private String[] dirstrs = new String[]{"r", "l", "d", "u"};

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {

        Point start = new Point(ball[0], ball[1], 0, "");

        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.z == b.z ? a.path.compareTo(b.path) : a.z - b.z);
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[ball[0]][ball[1]] = true;
        pq.offer(start);
        while(!pq.isEmpty()){
            Point pos = pq.poll();

            if(pos.x == hole[0] && pos.y == hole[1])
                return pos.path;

            visited[pos.x][pos.y] = true;

            for(int i = 0; i < dirs.length; i ++){
                int[] dir = dirs[i];
                String dirstr = dirstrs[i];
                int x = pos.x, y = pos.y;
                int dist = 0;
                while(x + dir[0] >= 0 && x + dir[0] < m &&
                        y + dir[1] >= 0 && y + dir[1] < n &&
                        maze[x + dir[0]][y + dir[1]] != 1)
                {
                    x += dir[0]; y += dir[1]; dist ++;
                    if(x == hole[0] && y == hole[1]){
                        break;
                    }
                }

                if(!visited[x][y]){
                    pq.offer(new Point(x, y, pos.z + dist, pos.path + dirstr));

                }
            }
        }

        return "impossible";

    }
}