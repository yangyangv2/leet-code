package prob317.shortest.distance.from.all.buildings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 3/6/2018.
 */
public class Solution {

    /*
        graph

        1 - 0       0 - 1
        |   |       |   |
        0 - 0 - 0 - 0 - 0
        |   |   |   |   |
        0 - 0 - 1 - 0 - 0

        Complexity: O(mnk)
    */
    public int shortestDistance(int[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int res = Integer.MAX_VALUE;
        List<int[]> buildings = new ArrayList<>();
        int m = grid.length, n = grid[0].length;

        // build up building list
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(grid[i][j] == 1) {
                    buildings.add(new int[]{i, j});
                }
            }
        }

        // find and mark distance to each point from each building

        // total distance from this node to all buildings
        int[][][] dist = new int[m][n][buildings.size()];

        int[][] visits = new int[m][n];

        for(int k = 0; k < buildings.size(); k ++){
            int[] building = buildings.get(k);
            dfs(building[0], building[1], k, 0, dist, visits, grid);
        }

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(grid[i][j] != 0) continue;
                if(visits[i][j] != buildings.size()) continue;

                int distance = 0;
                for(int k = 0; k < buildings.size(); k ++){
                    distance += dist[i][j][k];
                }
                res = Math.min(res, distance);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(int i, int j, int k, int d, int[][][] dist, int[][] visits, int[][] grid){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || i == m || j < 0 || j == n) return;
        if(d != 0 && grid[i][j] != 0) return;

        if(dist[i][j][k] == 0){
            visits[i][j] ++;
        } else if(dist[i][j][k] <= d){
            return;
        }

        // visit !
        dist[i][j][k] = d;

        dfs(i + 1, j, k, d + 1, dist, visits, grid);
        dfs(i, j + 1, k, d + 1, dist, visits, grid);
        dfs(i - 1, j, k, d + 1, dist, visits, grid);
        dfs(i, j - 1, k, d + 1, dist, visits, grid);
    }
}
