package prob407.trapping.rain.water.ii;

import java.util.PriorityQueue;

public class Solution {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;
        int water = 0, m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<int[]> minLevels = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i ++){
            minLevels.offer(new int[]{i, 0, heightMap[i][0]});
            visited[i][0] = true;
            minLevels.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][n - 1] = true;
        }

        for(int j = 1; j < n - 1; j ++){
            minLevels.offer(new int[]{0, j, heightMap[0][j]});
            visited[0][j] = true;
            minLevels.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[m - 1][j] = true;
        }


        int[] cur = null;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int nx = 0, ny = 0;

        while(!minLevels.isEmpty()){
            cur = minLevels.poll();
            for(int[] dir: dirs){
                nx = cur[0] + dir[0]; ny = cur[1] + dir[1];
                if(nx < 0 || ny < 0 || nx == m || ny == n || visited[nx][ny]) continue;
                water += Math.max(0, cur[2] - heightMap[nx][ny]);
                minLevels.offer(new int[]{nx, ny, Math.max(heightMap[nx][ny], cur[2])});
                visited[nx][ny] = true;
            }
        }

        return water;
    }
}