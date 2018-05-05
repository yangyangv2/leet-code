package prob305.number.of.Islands.ii;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 2/20/2018.
 * Modified by yanya04 on 5/5/2018.
 */
public class Solution {

    class UF{

        int[] parents;
        int m, n, count;
        int[][] map;
        UF(int m, int n){
            this.m = m;
            this.n = n;
            map = new int[m][n];
            parents = new int[m * n];
            int id = 0;
            for(int i = 0; i < m; i ++)
                for(int j = 0; j < n; j++){
                    id = id(i, j);
                    parents[id] = id;
                }

        }

        private int id(int x, int y){
            return x * n + y;
        }

        private int find(int x){
            while(x != parents[x]){
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        private void union(int x1, int y1, int x2, int y2){
            int id1 = id(x1, y1), id2 = id(x2, y2);
            id1 = find(id1);
            id2 = find(id2);
            if(id1 != id2){
                parents[id1] = id2;
                count --;
            }
        }

        void addIsland(int x, int y){
            if(map[x][y] == 1) return;
            map[x][y] = 1;
            count ++;
            if(x > 0 && map[x - 1][y] == 1) union(x, y, x - 1, y);
            if(x < m - 1 && map[x + 1][y] == 1) union(x, y, x + 1, y);
            if(y > 0 && map[x][y - 1] == 1) union(x, y, x, y - 1);
            if(y < n - 1 && map[x][y + 1] == 1) union(x, y, x, y + 1);
        }

        int getIslandCount(){
            return count;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        List<Integer> res = new ArrayList<>();
        if(positions == null || positions.length == 0) return res;

        UF uf = new UF(m, n);
        for(int[] position: positions){
            uf.addIsland(position[0], position[1]);
            res.add(uf.getIslandCount());
        }

        return res;
    }
}