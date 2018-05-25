package prob289.game.of.life;

import static java.lang.Math.*;
/**
 * Created by yanya04 on 2/3/2018.
 * Modified by yanya04 on 5/24/2018.
 */
public class Solution {

    /*
        1. change 0 to 2 to represent die
        2.  01 - live and die next
            11 - live and live next
            00 - die and die next
            10 - die and live next
    */
    public void gameOfLife(int[][] board) {

        if(board == null || board.length == 0 || board[0].length == 0)
            return;

        turn(board);

        finish(board);

    }

    private void turn(int[][] board){

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                int live = countNeighbours(board, i, j);
                if(live == 2){
                    // stay live
                    if(board[i][j] == 1)
                        board[i][j] += 2;   //  => 11
                } else if(live == 3){
                    // become live
                    board[i][j] += 2;       //  => 11 or 10
                }
            }
        }
    }

    private int countNeighbours(int[][] board, int i, int j){
        int live = 0;
        int m = board.length;
        int n = board[0].length;
        for(int r = max(0, i - 1); r <= min(m - 1, i + 1); r ++)
            for(int c = max(0, j - 1); c <= min(n - 1, j + 1); c ++){
                if(r == i && c == j) continue;
                live += board[r][c] & 1;
            }
        return live;
    }


    private void finish(int[][] board){
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++)
                board[i][j] = board[i][j] >> 1;
        }
    }
}