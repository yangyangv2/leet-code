package prob200.number.of.islands;

/**
 * Created by yanya04 on 10/22/2017.
 * Modified by yanya04 on 3/12/2018.
 * Modified by yanya04 on 5/5/2018.
 */
public class Solution {

    class UF {
        int[] parents;
        int m, n, count;
        UF(char[][] grid){
            m = grid.length;
            n = grid[0].length;

            int id = 0;
            parents = new int[m * n];
            for(int i = 0; i < m; i ++)
                for(int j = 0; j < n; j ++){
                    id = id(i, j);
                    parents[id] = id;
                    if(grid[i][j] == '1')
                        count ++;
                }
        }

        int id(int x, int y){
            return x * n + y;
        }

        int find(int id){
            while(id != parents[id]){
                parents[id] = parents[parents[id]];
                id = parents[id];
            }
            return id;
        }

        void union(int x1, int y1, int x2, int y2){
            int id1 = id(x1, y1), id2 = id(x2, y2);
            id1 = find(id1);
            id2 = find(id2);
            if(id1 != id2){
                parents[id1] = id2;
                count --;
            }
        }
    }


    private void check(UF uf, int i, int j, char[][] grid){
        if(grid[i][j] != '1') return;
        int m = grid.length, n = grid[0].length;
        if(i > 0 && grid[i - 1][j] == '1') uf.union(i, j, i - 1, j);
        if(i < m - 1 && grid[i + 1][j] == '1') uf.union(i, j, i + 1, j);
        if(j > 0 && grid[i][j - 1] == '1') uf.union(i, j, i, j - 1);
        if(j < n - 1 && grid[i][j + 1] == '1') uf.union(i, j, i, j + 1);
    }


    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0) return 0;

        UF uf = new UF(grid);
        int m = grid.length, n = grid[0].length;

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                check(uf, i, j, grid);
            }
        }
        return uf.count;

    }
}