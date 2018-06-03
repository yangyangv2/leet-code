package prob417.pacific.atlantic.water.flow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
    Modified by yanya04 on 6/2/2018.
 */
public class Solution {

    private final int[][] dirs = new int[][]{ {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

    public List<int[]> pacificAtlantic(int[][] matrix) {
        //return bfs(matrix);
        return dfs(matrix);
    }

    private List<int[]> dfs(int[][] matrix){
        List<int[]> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return result;

        int m = matrix.length, n = matrix[0].length;

        boolean[][] pvisit = new boolean[m][n];
        boolean[][] avisit = new boolean[m][n];

        for(int i = 0; i < m; i ++){
            dfs(matrix, pvisit, i, 0, Integer.MIN_VALUE);
            dfs(matrix, avisit, i, n - 1, Integer.MIN_VALUE);
        }

        for(int i = 0; i < n; i ++){
            dfs(matrix, pvisit, 0, i, Integer.MIN_VALUE);
            dfs(matrix, avisit, m - 1, i, Integer.MIN_VALUE);
        }

        // chekc collapsed visits

        for(int i = 0; i < m; i ++)
            for(int j = 0; j < n; j ++)
                if(pvisit[i][j] && avisit[i][j])
                    result.add(new int[]{i, j});

        return result;
    }


    private void dfs(int[][] matrix, boolean[][] visit, int x, int y, int height){
        int m = matrix.length, n = matrix[0].length;
        if(x < 0 || x == m || y < 0 || y == n || visit[x][y] || height > matrix[x][y]) return;
        visit[x][y] = true;
        for(int[] dir: dirs){
            dfs(matrix, visit, x + dir[0], y + dir[1], matrix[x][y]);
        }
    }



    private List<int[]> bfs(int[][] matrix){


        // bfs

        // two queues, pacific, atlantic
        // two visit maps

        List<int[]> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return result;
        }

        int m = matrix.length, n = matrix[0].length;

        boolean[][] pvisit = new boolean[m][n];
        boolean[][] avisit = new boolean[m][n];

        Deque<int[]> pqueue = new ArrayDeque<>();
        Deque<int[]> aqueue = new ArrayDeque<>();

        for(int i = 0; i < m; i ++){
            pqueue.offer(new int[]{i, 0});
            aqueue.offer(new int[]{i, n - 1});
            pvisit[i][0] = true;
            avisit[i][n - 1] = true;
        }

        for(int i = 0; i < n; i ++){
            pqueue.offer(new int[]{0, i});
            aqueue.offer(new int[]{m - 1, i});
            pvisit[0][i] = true;
            avisit[m - 1][i] = true;
        }

        bfs(matrix, pqueue, pvisit);
        bfs(matrix, aqueue, avisit);

        // find collapsed visits

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(pvisit[i][j] && avisit[i][j]){
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }


    private void bfs(int[][] matrix, Deque<int[]> queue, boolean[][] visit){
        int m = matrix.length, n = matrix[0].length;
        while(!queue.isEmpty()){
            int[] co = queue.poll();

            // 4 directions
            for(int[] dir: dirs){
                int x = co[0] + dir[0], y = co[1] + dir[1];

                if(x < 0 || x == m || y < 0 || y == n || visit[x][y] || matrix[x][y] < matrix[co[0]][co[1]]) continue;

                visit[x][y] = true;

                queue.offer(new int[]{x, y});
            }
        }
    }
}


