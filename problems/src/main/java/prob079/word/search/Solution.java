package prob079.word.search;

/**
 * Created by yanya04 on 1/5/2018.
 */
public class Solution {
    /*
        solution DFS

    */
    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i ++)
            for(int j = 0; j < board[0].length; j ++){
                if(exist(board, i, j, word, 0)){
                    return true;
                }
            }

        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int start){

        if(start >= word.length())
            return true;

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;

        char c = word.charAt(start);
        boolean result = false;
        if(board[i][j] == c ){
            board[i][j] = '#';

            result = result || exist(board, i + 1, j, word, start + 1);
            result = result || exist(board, i - 1, j, word, start + 1);
            result = result || exist(board, i, j + 1, word, start + 1);
            result = result || exist(board, i, j - 1, word, start + 1);
            board[i][j] = c;
        }
        return result;
    }
}
