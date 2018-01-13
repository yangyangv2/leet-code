package prob130.surrounded.regions;

/**
 * Created by yanya04 on 1/10/2018.
 */
public class Solution {

    /*  DFS
        start from the boarder
    */
    public void solve(char[][] board) {

        if(board == null || board.length == 0 || board[0].length == 0)
            return;

        int m = board.length, n = board[0].length;

        for(int i = 0; i < m; i ++){
            if(board[i][0] == 'O')
                dfs(board, i, 0);

            if(board[i][n - 1] == 'O')
                dfs(board, i, n - 1);
        }

        for(int i = 0; i < n; i ++){
            if(board[0][i] == 'O')
                dfs(board, 0, i);

            if(board[m - 1][i] == 'O')
                dfs(board, m - 1, i);
        }

        for(int i = 0; i < m; i ++)
            for(int j = 0; j < n; j ++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '1')
                    board[i][j] = 'O';
            }
    }

    private void dfs(char[][] board, int i, int j){
        int m = board.length, n = board[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O')
            return;

        board[i][j] = '1';

        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
    }
}