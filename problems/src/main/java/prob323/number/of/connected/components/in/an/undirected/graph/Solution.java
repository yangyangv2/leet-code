package prob323.number.of.connected.components.in.an.undirected.graph;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yanya04 on 8/13/2017.
 * Modified by yanya04 on 5/4/2018.
 */
public class Solution {


    class UnionFind{
        int[] parents;
        public UnionFind(int n){
            parents = new int[n];
            for(int i = 0; i < n; i ++)
                parents[i] = i;
        }

        public int find(int x){
            while(x != parents[x]){
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        public boolean union(int x, int y){
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

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int count = n;
        for(int[] edge: edges){
            if(uf.union(edge[0], edge[1])){
                count --;
            }
        }
        return count;
    }
}