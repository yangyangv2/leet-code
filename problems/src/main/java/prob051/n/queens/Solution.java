package prob051.n.queens;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*
        backtrack
    */

    public List<List<String>> solveNQueens(int n) {

        boolean[][] board = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        backtrack(board, 0, result);
        return result;
    }


    private List<String> assembly(boolean[][] board){
        List<String> result = new ArrayList<>();
        int n = board.length;
        for(int i = 0; i < n; i ++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j ++){
                sb.append(board[i][j] ? 'Q': '.');
            }
            result.add(sb.toString());
        }
        return result;
    }

    /*

    */
    private void backtrack(boolean[][] board, int row, List<List<String>> result){
        int n = board.length;
        for(int i = 0; i < n; i ++){
            if(isSafe(board, row, i)){
                board[row][i] = true;
                if(row == n - 1) {
                    // complete!
                    result.add(assembly(board));
                } else {
                    backtrack(board, row + 1, result);
                }
                board[row][i] = false;
            }
        }
    }


    /*
        check if place queen at row/col is safe
    */
    private boolean isSafe(boolean[][] board, int row, int col){
        int n = board.length;
        for(int i = 0; i < n; i ++){
            if(//board[row][i] ||
                    board[i][col]) return false;
        }
        for(int i = row, j = col; i < n && j < n; i ++, j ++){
            if(board[i][j]) return false;
        }
        for(int i = row, j = col; i > -1 && j > -1; i --, j --){
            if(board[i][j]) return false;
        }
        for(int i = row, j = col; i < n && j > -1; i ++, j --){
            if(board[i][j]) return false;
        }
        for(int i = row, j = col; i > -1 && j < n; i --, j ++){
            if(board[i][j]) return false;
        }
        return true;
    }
}