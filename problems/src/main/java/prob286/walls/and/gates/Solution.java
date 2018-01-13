package prob286.walls.and.gates;

/**
 * Created by yanya04 on 1/10/2018.
 */
public class Solution {
    /*
        dfs
    */
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;

        int m = rooms.length, n = rooms[0].length;
        for(int i = 0; i < m; i ++)
            for(int j = 0; j < n; j ++)
                if(rooms[i][j] == 0)
                    dfs(rooms, i, j, 0);

    }

    private void dfs(int[][] rooms, int i, int j, int step){

        int m = rooms.length, n = rooms[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || rooms[i][j] < step)
            return;

        rooms[i][j] = step;

        dfs(rooms, i - 1, j, step + 1);
        dfs(rooms, i + 1, j, step + 1);
        dfs(rooms, i, j - 1, step + 1);
        dfs(rooms, i, j + 1, step + 1);
    }
}
