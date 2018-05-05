package prob130.surrounded.regions;

/**
 * Created by yanya04 on 1/10/2018.
 * Modified by yanya04 on 5/5/2018.
 */
public class Solution {

    class UF{
        int[] parents;
        int m, n, edge;
        UF(char[][] board){
            m = board.length;
            n = board[0].length;
            parents = new int[m * n + 1];
            for(int i = 0 ; i < parents.length; i ++){
                parents[i] = i;
            }
            this.edge = m * n;
        }
        int find(int x){
            while(x != parents[x]){
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        int id(int x, int y){
            return x * n + y;
        }

        void union(int x, int y){
            x = find(x); y = find(y);
            if(x != y){
                if(x > y){
                    parents[y] = x;
                } else {
                    parents[x] = y;
                }
            }
        }

    }


    private void check(UF uf, int i, int j, int m, int n, char[][] board){
        if (i < 0 || j < 0 || i == m || j == n || board[i][j] != 'O' || uf.find(uf.id(i, j)) == uf.edge ){
            return;
        }
        else if(i == 0 || j == 0 || i == m - 1 || j == n - 1){
            uf.union(uf.id(i, j), uf.edge);
        } else {
            if(board[i][j + 1] == 'O') uf.union(uf.id(i, j), uf.id(i, j + 1));
            if(board[i][j - 1] == 'O') uf.union(uf.id(i, j), uf.id(i, j - 1));
            if(board[i + 1][j] == 'O') uf.union(uf.id(i, j), uf.id(i + 1, j));
            if(board[i - 1][j] == 'O') uf.union(uf.id(i, j), uf.id(i - 1, j));
        }
    }

    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        UF uf = new UF(board);

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(board[i][j] == 'O'){
                    check(uf, i, j, m, n, board);
                }
            }
        }

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(board[i][j] == 'O' && uf.edge != uf.find(uf.id(i, j))){
                    board[i][j] = 'X';
                }
            }
        }


    }
}