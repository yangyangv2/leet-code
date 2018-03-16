package prob200.number.of.islands;

/**
 * Created by yanya04 on 10/22/2017.
 * Modified by yanya04 on 3/12/2018.
 */
public class Solution {
    public int numIslands(char[][] grid) {
        // return bfs(grid);

        return uf(grid);
    }

    /*  Union-Find solution    */

    private static class UFSet{
        private int[] parents;
        private int m, n, count;

        public UFSet(char[][] grid){
            this.m = grid.length;
            this.n = grid[0].length;

            this.parents = new int[m * n];
            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j ++){
                    if(grid[i][j] == '1'){
                        parents[id(i, j)] = id(i, j);
                        count ++;
                    }
                }
            }
        }

        private int find(int id){
            if(parents[id] == id)
                return id;
            // compression
            parents[id] = find(parents[id]);
            return parents[id];
        }

        public boolean union(int i, int j, int m, int n){
            int p1 = find(id(i, j));
            int p2 = find(id(m, n));
            if(p1 == p2) return false;
            count --;
            if(p1 < p2){
                parents[p2] = p1;
            } else {
                parents[p1] = p2;
            }
            return true;
        }

        private int id(int i, int j){
            return i * n + j;
        }
    }


    private int uf(char[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        UFSet uf = new UFSet(grid);
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(grid[i][j] == '1'){
                    check(uf, i, j, i + 1, j, grid);
                    check(uf, i, j, i - 1, j, grid);
                    check(uf, i, j, i, j + 1, grid);
                    check(uf, i, j, i, j - 1, grid);
                }
            }
        }
        return uf.count;
    }

    private void check(UFSet uf, int i, int j, int x, int y, char[][] grid){

        int m = grid.length, n = grid[0].length;
        if(x < 0 || y < 0 || x == m || y == n || grid[x][y] != '1')
            return;

        uf.union(i, j, x, y);
    }


    /*  BFS solution    */
    private int bfs(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(grid[i][j] == '1'){
                    count ++;
                    clear(i, j, grid);
                }
            }
        }
        return count;
    }

    private void clear(int i, int j, char[][] grid){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        clear(i + 1, j, grid);
        clear(i - 1, j, grid);
        clear(i, j + 1, grid);
        clear(i, j - 1, grid);
    }
}
