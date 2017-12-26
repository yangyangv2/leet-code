package prob052.n.queens.ii;

public class Solution {

    private int counter = 0;
    public int totalNQueens(int n) {

        boolean[][] board = new boolean[n][n];
        backtrack(board, 0);

        return counter;
    }


    private void backtrack(boolean[][] board, int row){
        int n = board.length;
        for(int i = 0; i < n; i++){
            if(isSafe(board, row, i)){
                board[row][i] = true;
                if(row == n - 1){
                    counter ++;
                } else {
                    backtrack(board, row + 1);
                }
                board[row][i] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int row, int col){
        int n = board.length;
        for(int i = 0; i < n; i ++){
            if(// board[row][i] ||
                    board[i][col]) return false;
        }

        for(int i = row, j = col; i < n && j < n; i ++, j ++){
            if(board[i][j]) return false;
        }
        for(int i = row, j = col; i > -1 && j > -1; i --, j --){
            if(board[i][j]) return false;
        }
        for(int i = row, j = col; i < n && j > - 1; i ++, j --){
            if(board[i][j]) return false;
        }
        for(int i = row, j = col; i > -1 && j < n; i --, j ++){
            if(board[i][j]) return false;
        }
        return true;
    }
}