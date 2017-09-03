package prob036.valid.sudoku;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/30/2017.
 */
public class Solution {

    private boolean isValid(boolean[] used, char c){
        if(c != '.'){
            int index = c - '0' - 1;
            if(used[index] == true){
                return false;
            }
            used[index] = true;
        }
        return true;
    }


    public boolean isValidSudoku(char[][] board) {

        if(board == null || board.length == 0) return true;

        boolean[] used1 = new boolean[9]; // default false
        boolean[] used2 = new boolean[9]; // default false
        boolean[] used3 = new boolean[9]; // default false

        for(int i = 0; i < 9; i ++){
            Arrays.fill(used1, false);
            Arrays.fill(used2, false);
            for(int j = 0; j < 9; j ++){
                if(!isValid(used1, board[i][j])){
                    return false;
                }
                if(!isValid(used2, board[j][i])){
                    return false;
                }
            }
        }

        for(int i = 0; i < 9; i += 3){
            for(int j = 0; j < 9; j += 3){
                Arrays.fill(used3, false);
                for(int m = i; m < i + 3; m ++){
                    for(int n = j; n < j + 3; n ++){
                        if(!isValid(used3, board[m][n])){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
