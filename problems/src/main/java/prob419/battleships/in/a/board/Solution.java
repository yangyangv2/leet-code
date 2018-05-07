package prob419.battleships.in.a.board;

public class Solution {
    public int countBattleships(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return 0;
        int count = 0, m = board.length, n = board[0].length;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(i > 0 && board[i - 1][j] == 'X') continue;
                if(j > 0 && board[i][j - 1] == 'X') continue;
                if(board[i][j] == 'X') count ++;
            }
        }
        return count;
    }
}