package prob261.graph.valid.tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Modified by yanya04 On 5/5/2018.
 */
public class Solution {


    class UF{
        private int[] parents;
        UF(int n){
            parents = new int[n];
            for(int i = 0; i < n; i ++){
                parents[i] = i;
            }
        }

        int find(int x){
            while(x != parents[x]){
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        boolean union(int x, int y){
            x = find(x);
            y = find(y);
            if(x != y){
                parents[x] = y;
                return true;
            } else {
                return false;
            }
        }

    }

    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);

        int count = n;
        for(int[] edge : edges){
            if(uf.union(edge[0], edge[1])) count --;
            else return false;
        }
        if(count != 1) return false;

        return true;

    }
}
