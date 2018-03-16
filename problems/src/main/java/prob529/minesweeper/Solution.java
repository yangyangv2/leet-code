package prob529.minesweeper;

/**
 * Created by yanya04 on 3/16/2018.
 */
public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {

        if(board == null || board.length == 0 || board[0].length == 0)
            return board;
        int m = board.length, n = board[0].length;
        char[][] res = new char[m][n];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                res[i][j] = board[i][j];
            }
        }

        int x = click[0], y = click[1];
        if(res[x][y] == 'M'){
            res[x][y] = 'X';
        } else {
            dfs(board, res, x, y);
        }
        return res;

    }

    //  x, y is valid
    private int countMine(char[][] board, int x, int y){

        int m = board.length, n = board[0].length;
        int count = 0;

        for(int i = -1; i < 2; i ++){
            for(int j = -1; j < 2; j ++){
                if(i == 0 && j == 0) continue;
                int r = x + i, c = y + j;
                if(r < 0 || c < 0 || r == m || c == n) continue;
                if(board[r][c] == 'M') count ++;
            }
        }
        return count;
    }

    private void dfs(char[][] board, char[][] res, int x, int y){
        int m = board.length, n = board[0].length;
        if(x < 0 || y < 0 || x == m || y == n || res[x][y] != 'E'){
            return;
        }

        int mines = countMine(board, x, y);

        if(mines == 0) {
            res[x][y] = 'B';
            // go next

            for(int i = -1; i < 2; i ++){
                for(int j = -1; j < 2; j ++){
                    if(i == 0 && j == 0) continue;
                    int r = x + i, c = y + j;
                    if(r < 0 || c < 0 || r == m || c == n) continue;
                    if(board[r][c] == 'E')  dfs(board, res, r, c);
                }
            }
        } else {
            res[x][y] = (char)('0' + mines);
            // stop
        }


    }
}