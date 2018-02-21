package prob547.friend.circles;

/**
 * Created by yanya04 on 2/20/2018.
 */
public class Solution {

    private static class UFSet {

        private int[] parents;

        UFSet(int m){
            this.parents = new int[m];
            for(int i = 0; i < m; i ++){
                parents[i] = i;
            }
        }

        private int find(int p){
            while(parents[p] != p){
                parents[p] = parents[parents[p]];
                p = parents[p];
            }
            return p;
        }

        boolean union(int i, int j){
            int p1 = find(i);
            int p2 = find(j);
            if(p1 == p2) return false;

            if(p1 < p2){
                parents[p2] = p1;
            } else {
                parents[p1] = p2;
            }
            return true;
        }

    }
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0) return 0;
        int n = M.length;
        int count = n;

        UFSet set = new UFSet(n);

        for(int i = 0; i < n; i ++){
            for(int j = i + 1; j < n; j ++){
                if(M[i][j] == 1){
                    if(set.union(i, j)){
                        count --;
                    }
                }
            }
        }

        return count;
    }
}