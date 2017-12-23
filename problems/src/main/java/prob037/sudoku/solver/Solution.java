package prob037.sudoku.solver;

/**
 * Created by yanya04 on 12/22/2017.
 */
public class Solution {

    /*
        DFS

    */

    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i ++){
            if(board[row][i] == c) return false;
            if(board[i][col] == c) return false;
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }

    private boolean solve(char[][] board){
        for(int i = 0; i < 9; i ++){
            for(int j = 0; j < 9; j ++){
                if(board[i][j] != '.') continue;
                for(int k = 0; k < 9; k ++){
                    char c = (char)(k + '1');
                    if(isValid(board, i, j, c)){
                        board[i][j] = c;
                        if(solve(board)){
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }



    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
