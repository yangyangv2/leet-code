package prob079.word.search;

/**
 * Created by yanya04 on 1/5/2018.
 * Modified by yanya04 On 5/5/2018.
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return false;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(dfs(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int start){
        if(start == word.length())
            return true;

        int m = board.length, n = board[0].length;
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] != word.charAt(start))
            return false;

        board[i][j] = '#';
        boolean res = false;

        res = res || dfs(board, i - 1, j, word, start + 1);
        res = res || dfs(board, i + 1, j, word, start + 1);
        res = res || dfs(board, i, j - 1, word, start + 1);
        res = res || dfs(board, i, j + 1, word, start + 1);

        board[i][j] = word.charAt(start);
        return res;
    }
}
