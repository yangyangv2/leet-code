package prob766.toeplitz.matrix;

/**
 * Created by yanya04 on 5/25/2018.
 */
public class Solution {
    /*
         [0,1]
        [1,2,3,4]
        [5,1,2,3] [1,1]
        [9,5,1,2] [2,3]

        verify [i][j] = [i+1][j+1]

    */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int x = 0, y = 0;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                x = i + 1; y = j + 1;
                if(x == m || y == n) continue;
                if(matrix[i][j] != matrix[x][y])
                    return false;
            }
        }
        return true;

    }
}
