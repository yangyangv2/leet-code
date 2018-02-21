package prob305.number.of.Islands.ii;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 2/20/2018.
 */
public class Solution {

    private static class UFSet{

        int[] parents;
        int[][] positions;
        int m;
        int n;
        int count;
        UFSet(int m, int n){
            this.m = m;
            this.n = n;
            parents = new int[m * n];
            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j ++){
                    parents[id(i, j)] = id(i, j);
                }
            }
            positions = new int[m][n];
        }

        private boolean union(int x1, int y1, int x2, int y2){
            int id1 = find(x1, y1);
            int id2 = find(x2, y2);
            if(id1 == id2)
                return false;

            if(id1 <= id2){
                parents[id2] = id1;
            } else {
                parents[id1] = id2;
            }
            return true;
        }

        // for n, [1,2,3 ... n]
        private int id(int r, int c){
            return r * n  + c;
        }

        private int find(int r, int c){
            int id = id(r, c);
            while(parents[id] != id){
                parents[id] = parents[parents[id]];
                id = parents[id];
            }
            return id;
        }

        private boolean isConnected(int r, int c){
            if(r < 0 || c < 0 || r == m || c == n){
                return false;
            }
            return positions[r][c] == 1;
        }

        private final static int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1} , {-1, 0}};


        int add(int r, int c){
            positions[r][c] = 1;
            count ++;
            for(int[] dir: dirs){
                if(isConnected(r + dir[0], c + dir[1])){
                    if(union(r, c, r + dir[0], c + dir[1])){
                        count --;
                    }
                }
            }
            return count;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UFSet ufset = new UFSet(m, n);

        List<Integer> list = new ArrayList<>();
        for(int[] position : positions){
            int x = position[0], y = position[1];
            list.add(ufset.add(x, y));
        }
        return list;
    }
}
