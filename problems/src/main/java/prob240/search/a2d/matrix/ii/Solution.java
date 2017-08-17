package prob240.search.a2d.matrix.ii;

/**
 * Created by yanya04 on 8/15/2017.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }

        int col = 0, row = matrix.length - 1;

        while(col < matrix[0].length && row >= 0){
            int value = matrix[row][col];
            if(value == target){
                return true;
            } else if (value < target){
                col ++;
            } else {
                row --;
            }
        }

        return false;
    }
}
